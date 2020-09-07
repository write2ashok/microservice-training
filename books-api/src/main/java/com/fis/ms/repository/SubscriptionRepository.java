package com.fis.ms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ms.model.Subscription;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>
{

	List<Subscription> findAllSubscriptionById(Long id);

	Subscription save(Subscription address);
	
	Subscription findSubscriptionById(Long id);
	
}
