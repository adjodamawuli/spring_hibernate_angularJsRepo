package com.esprit.springproject.service;

import com.esprit.springproject.persistence.entity.Document;
import com.esprit.springproject.service.common.IAbstractService;

public interface IDocumentService extends IAbstractService<Document, Long> {
	Document findDocumentByName(String name);
}
