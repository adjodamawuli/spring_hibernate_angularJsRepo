package com.esprit.springproject.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.springproject.persistence.entity.Image;
import com.esprit.springproject.persistence.repository.IGenericDao;
import com.esprit.springproject.persistence.repository.IImageDao;
import com.esprit.springproject.service.IImageService;
import com.esprit.springproject.service.common.AbstractService;

@Service
public class ImageService extends AbstractService<Image, Long> implements IImageService {
	@Autowired(required = true)
	private IImageDao imageDao;

	@Override
	protected IGenericDao<Image, Long> getGenericDao() {
		return imageDao;
	}

}
