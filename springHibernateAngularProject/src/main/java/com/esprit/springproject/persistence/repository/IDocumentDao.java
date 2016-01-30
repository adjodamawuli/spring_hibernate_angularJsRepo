package com.esprit.springproject.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.springproject.persistence.entity.Document;

public interface IDocumentDao extends IGenericDao<Document, Long> {
	@Query("select d from Document d where d.name =:name")
	Document findDocumentByName(@Param("name") String name);
}
