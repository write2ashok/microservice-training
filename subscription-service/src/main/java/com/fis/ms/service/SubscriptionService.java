package com.fis.ms.service;

import java.util.List;

import com.fis.ms.model.Subscription;

public interface SubscriptionService {

	List<Subscription> findAllSubscriptionById(Long id);

	List<Subscription> findAllSubscriptions();
	
	Subscription save(Subscription address);
	
	Subscription findSubscriptionById(Long id);

	Subscription subscribeToBook(Subscription suscription);

	Subscription returnBook(Subscription suscription);
}
