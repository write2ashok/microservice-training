package com.fis.ms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ms.controller.response.ApiResponse;
import com.fis.ms.controller.response.ConstructResponseEntity;
import com.fis.ms.model.Subscription;
import com.fis.ms.service.SubscriptionService;

@RestController("api/subscription-service/")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/subscriptions")
	@ResponseBody
	public ResponseEntity<ApiResponse> getAllSubscriptions() {
		List<Subscription> subList = subscriptionService.findAllSubscriptions();
		if (subList == null || subList.isEmpty()) 
		{
			return ConstructResponseEntity.getResponseEntity("Error", HttpStatus.NOT_FOUND, subList);
		}
		return ConstructResponseEntity.getResponseEntity("Success", HttpStatus.OK, subList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/subscriptions")
	@ResponseBody
	public ResponseEntity<ApiResponse> subscribeToBook(@Valid @RequestBody Subscription suscription) {
		Subscription subAvble = subscriptionService.subscribeToBook(suscription);
		if (subAvble == null) 
		{
			return ConstructResponseEntity.getResponseEntity("Book copies not available for subscription.", HttpStatus.UNPROCESSABLE_ENTITY, subAvble);
		}
		return ConstructResponseEntity.getResponseEntity("Successful creation of subscription record.", HttpStatus.CREATED, subAvble);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/returns")
	@ResponseBody
	public ResponseEntity<ApiResponse> returnBook(@Valid @RequestBody Subscription suscription) {
		Subscription subAvble = subscriptionService.returnBook(suscription);
		if (subAvble == null) 
		{
			return ConstructResponseEntity.getResponseEntity("Error", HttpStatus.NOT_FOUND, subAvble);
		}
		return ConstructResponseEntity.getResponseEntity("Successful creation of subscription record.", HttpStatus.CREATED, subAvble);
	}

}
