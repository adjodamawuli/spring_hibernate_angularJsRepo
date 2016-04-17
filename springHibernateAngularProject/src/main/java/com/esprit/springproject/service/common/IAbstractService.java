package com.esprit.springproject.service.common;

import java.io.Serializable;
import java.util.List;

public interface IAbstractService<T extends Serializable, ID extends Serializable> {
	T findOne(ID id);

	List<T> findAll();

	T save(T t);

	T update(T t);

	void delete(ID id);
}
