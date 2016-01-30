package com.esprit.springproject.web.controller.test;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * A service to save, find and get documents from an archive.
 * 
 * @author Daniel Murygin <daniel.murygin[at]gmail[dot]com>
 */
@Service("archiveService")
public class ArchiveService implements IArchiveService, Serializable {

	private static final long serialVersionUID = 8119784722798361327L;

	@Autowired
	private IDocumentRepo documentRepo;

	/**
	 * Saves a document in the archive.
	 * 
	 * @see org.murygin.archive.service.IArchiveService#save(org.murygin.archive.service.Document)
	 */
	public DocumentMetadata save(Document document) {
		getDocumentDao().insert(document);
		return document.getMetadata();
	}

	/**
	 * Finds document in the archive
	 * 
	 * @see org.murygin.archive.service.IArchiveService#findDocuments(java.lang.String,
	 *      java.util.Date)
	 */
	public List<DocumentMetadata> findDocuments(String personName, Date date) {
		return getDocumentDao().findByPersonNameDate(personName, date);
	}

	/**
	 * Returns the document file from the archive
	 * 
	 * @see org.murygin.archive.service.IArchiveService#getDocumentFile(java.lang.String)
	 */
	public byte[] getDocumentFile(String id) {
		Document document = getDocumentDao().load(id);
		if (document != null) {
			return document.getFileData();
		} else {
			return null;
		}
	}

	public IDocumentRepo getDocumentDao() {
		return documentRepo;
	}

	public void setDocumentDao(IDocumentRepo documentDao) {
		documentRepo = documentDao;
	}

}
