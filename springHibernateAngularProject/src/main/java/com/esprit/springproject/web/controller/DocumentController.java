package com.esprit.springproject.web.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.esprit.springproject.persistence.entity.Document;
import com.esprit.springproject.service.IDocumentService;

@Controller
@Scope("session")
public class DocumentController {
	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	@Autowired(required = true)
	private IDocumentService documentService;

	@ResponseBody
	@RequestMapping(value = "/data/fileupload", method = RequestMethod.POST)
	public String postFile(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "data") Object data) throws Exception {
		System.out.println("data = " + data);
		System.out.println("OK!----------------------------------------");
		return "OK!----------------------------------------";
	}
	
    @RequestMapping(value="/newDocument", headers = "'Content-Type': 'multipart/form-data'", method = RequestMethod.POST)
    public void UploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {

        Iterator<String> itr=request.getFileNames();

        MultipartFile file=request.getFile(itr.next());

        String fileName=file.getOriginalFilename();
        System.out.println("OK!----------------------------------------");
        System.out.println(fileName);
    }

	@RequestMapping(value = "/documents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Document>> listAllUsers() {
		List<Document> documents = documentService.findAll();
		if (documents.isEmpty()) {
			// You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<Document>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Document>>(documents, HttpStatus.OK);
	}

	@RequestMapping(value = "/savD", method = RequestMethod.POST)
	public ResponseEntity<Void> saveFile(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Document document = new Document();
				document.setName(file.getOriginalFilename());
				document.setContent(bytes);
				documentService.save(document);
			} catch (Exception e) {
			}
		} else {
		}

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity uploadFile(MultipartHttpServletRequest request) {

		try {
			Iterator<String> itr = request.getFileNames();

			while (itr.hasNext()) {
				String uploadedFile = itr.next();
				MultipartFile file = request.getFile(uploadedFile);
				String mimeType = file.getContentType();
				String filename = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				Document document = new Document();
				document.setContent(bytes);
				document.setName(filename);
				document.setMimeType(mimeType);
				documentService.save(document);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("{}", HttpStatus.OK);
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity downloadFile(@RequestParam("filename") String filename) {

		Document document = documentService.findDocumentByName(filename);

		// No file found based on the supplied filename
		if (document == null) {
			return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
		}

		// Generate the http headers with the file properties
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "attachment; filename=" + document.getName());

		// Split the mimeType into primary and sub types
		String primaryType, subType;
		try {
			primaryType = document.getMimeType().split("/")[0];
			subType = document.getMimeType().split("/")[1];
		} catch (IndexOutOfBoundsException | NullPointerException ex) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		headers.setContentType(new MediaType(primaryType, subType));

		return new ResponseEntity<>(document.getContent(), headers, HttpStatus.OK);
	}
}
