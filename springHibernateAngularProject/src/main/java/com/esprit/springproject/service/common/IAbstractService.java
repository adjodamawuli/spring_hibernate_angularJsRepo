package com.esprit.springproject.service.common;

import java.io.Serializable;
import java.util.List;

public interface IAbstractService<T extends Serializable, ID extends Serializable> {
	T findOne(ID id);

	List<T> findAll();

	void save(T t);

	void update(T t);

	void delete(ID id);
}
