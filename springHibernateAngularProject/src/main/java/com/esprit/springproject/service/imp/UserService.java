package com.esprit.springproject.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.springproject.persistence.entity.User;
import com.esprit.springproject.persistence.repository.IGenericDao;
import com.esprit.springproject.persistence.repository.IUserDao;
import com.esprit.springproject.service.IUserService;
import com.esprit.springproject.service.common.AbstractService;

@Service
public class UserService extends AbstractService<User, Long> implements IUserService {
	@Autowired(required = true)
	private IUserDao userDao;

	@Override
	protected IGenericDao<User, Long> getGenericDao() {
		return userDao;
	}

}
