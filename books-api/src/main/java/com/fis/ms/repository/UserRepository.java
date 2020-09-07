package com.fis.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

	List<User> findAllById(Long id);

	User save(User address);
	
	User findUserById(Long id);

	User findBySubscriberName(String subscriberName);
}
