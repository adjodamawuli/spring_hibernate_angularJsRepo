package com.esprit.springproject.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.springproject.persistence.entity.Annonce;
import com.esprit.springproject.persistence.repository.IAnnonceDao;
import com.esprit.springproject.persistence.repository.IGenericDao;
import com.esprit.springproject.service.IAnnonceService;
import com.esprit.springproject.service.common.AbstractService;

@Service
public class AnnonceService extends AbstractService<Annonce, Long> implements IAnnonceService {
	@Autowired(required = true)
	private IAnnonceDao annonceDao;

	@Override
	protected IGenericDao<Annonce, Long> getGenericDao() {
		return annonceDao;
	}

}
