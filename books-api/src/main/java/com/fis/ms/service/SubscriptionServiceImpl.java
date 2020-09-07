package com.fis.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ms.model.Subscription;
import com.fis.ms.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository mSubscriptionRepository;

	@Override
	public List<Subscription> findAllSubscriptionById(Long id) {
		return mSubscriptionRepository.findAllSubscriptionById(id);
	}

	@Override
	public Subscription save(Subscription subscription) {
		return mSubscriptionRepository.save(subscription);
	}

	@Override
	public Subscription findSubscriptionById(Long id) {
		return mSubscriptionRepository.findSubscriptionById(id);
	}

	@Override
	public List<Subscription> findAllSubscriptions() {
		return mSubscriptionRepository.findAll();
	}

	@Override
	public Subscription subscribeToBook(Subscription subscription) {
		return mSubscriptionRepository.save(subscription);
	}

	@Override
	public Subscription returnBook(Subscription subscription) {
		return mSubscriptionRepository.save(subscription);
	}

}
