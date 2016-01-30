package com.esprit.springproject.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.springproject.persistence.entity.Etat;
import com.esprit.springproject.persistence.repository.IEtatDao;
import com.esprit.springproject.persistence.repository.IGenericDao;
import com.esprit.springproject.service.IEtatService;
import com.esprit.springproject.service.common.AbstractService;

@Service
public class EtatService extends AbstractService<Etat, Long> implements IEtatService {
	@Autowired(required = true)
	private IEtatDao etatDao;

	@Override
	protected IGenericDao<Etat, Long> getGenericDao() {
		return etatDao;
	}

}
