package com.esprit.springproject.service.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.esprit.springproject.persistence.repository.IGenericDao;

public abstract class AbstractService<T extends Serializable, ID extends Serializable>
		implements IAbstractService<T, ID> {

	protected abstract IGenericDao<T, ID> getGenericDao();

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractService() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public T findOne(ID id) {
		return getGenericDao().findOne(id);
	}

	public List<T> findAll() {
		return getGenericDao().findAll();
	}

	public T save(T t) {
		return  getGenericDao().saveAndFlush(t);
	}

	public T update(T t) {
		return getGenericDao().saveAndFlush(t);
	}

	public void delete(ID id) {
		getGenericDao().delete(id);
	}
}
