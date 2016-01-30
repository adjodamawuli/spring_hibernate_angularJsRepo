package com.esprit.springproject.persistence.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericDao<T extends Serializable, ID extends Serializable> extends JpaRepository<T, ID> {

}
