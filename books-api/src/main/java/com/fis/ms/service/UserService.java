package com.fis.ms.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fis.ms.model.User;

public interface UserService extends UserDetailsService  {

	List<User> findAllUserByUserid(Long userid);

	User save(User address);
	
	User findUserById(Long id);
}
