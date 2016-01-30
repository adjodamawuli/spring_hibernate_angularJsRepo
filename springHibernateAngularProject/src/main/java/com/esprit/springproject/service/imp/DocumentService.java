package com.esprit.springproject.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.springproject.persistence.entity.Document;
import com.esprit.springproject.persistence.repository.IDocumentDao;
import com.esprit.springproject.persistence.repository.IGenericDao;
import com.esprit.springproject.service.IDocumentService;
import com.esprit.springproject.service.common.AbstractService;

@Service
public class DocumentService extends AbstractService<Document, Long> implements IDocumentService {

	@Autowired(required = true)
	private IDocumentDao documentDao;

	@Override
	protected IGenericDao<Document, Long> getGenericDao() {
		return documentDao;
	}

	@Override
	public Document findDocumentByName(String name) {
		return documentDao.findDocumentByName(name);
	}

}
