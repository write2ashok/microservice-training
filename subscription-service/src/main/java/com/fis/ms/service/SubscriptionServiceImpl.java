package com.fis.ms.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fis.ms.controller.response.ApiResponse;
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
		String jsonStr = getBook(subscription.getBookid());
		String bookObj = "";
		try {
			ApiResponse response = new ObjectMapper().readValue(jsonStr, ApiResponse.class);
			String reqBodyData = new ObjectMapper().writeValueAsString(response.getResponseData());
			bookObj = reqBodyData;//(String) response.getResponseData().toString();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (jsonStr != null) {
			updateBookAvailability(bookObj, subscription.getBookid(), -1);
			subscription.setDateSubscribed(new Date());
			return mSubscriptionRepository.save(subscription);
		}
		return null;
	}

	@Override
	public Subscription returnBook(Subscription subscription) {
		String jsonStr = getBook(subscription.getBookid());
		String bookObj = "";
		try {
			ApiResponse response = new ObjectMapper().readValue(jsonStr, ApiResponse.class);
			String reqBodyData = new ObjectMapper().writeValueAsString(response.getResponseData());
			bookObj = reqBodyData;//(String) response.getResponseData().toString();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (jsonStr != null) {
			updateBookAvailability(bookObj, subscription.getBookid(), 1);
			subscription.setDateReturned(new Date());
			return mSubscriptionRepository.save(subscription);
		}
		return null;
	}

	private String getBook(Long id) {
		final String uri = "http://localhost:8080/api/book-service/books/{id}";

		RestTemplate restTemplate = new RestTemplate();
		Map params = new HashMap();
		params.put("id", id);

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class, params);
		String bodyContent = response.getBody();
		return bodyContent;
	}

	private void updateBookAvailability(String payload, Long id, int count) {
		final String uri = "http://localhost:8080/api/book-service/books/UpdateAvailability/{id}/{incremental_count}";

		RestTemplate restTemplate = new RestTemplate();
		Map params = new HashMap();
		params.put("id", id);
		params.put("incremental_count", count);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);
		restTemplate.postForLocation(uri, requestEntity, String.class, params);
	}

}
