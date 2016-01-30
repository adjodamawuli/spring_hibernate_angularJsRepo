package com.esprit.springproject.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.springproject.persistence.entity.User;

public interface IUserDao extends IGenericDao<User, Long> {
	@Query("select u from User u where u.login =:login")
	 User findByEmailAddress(@Param("login") String login);
}
