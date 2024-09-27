package com.event.eventApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.eventApp.model.Subscription;
import com.event.eventApp.service.SubscriptionService;

@RestController
@RequestMapping("api/subscriptions")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subService;
	
	@PostMapping
	public ResponseEntity<Subscription> subscribe(@Validated @RequestBody Subscription subcription){
		Subscription createdSubscription = subService.subscribe(subcription);
		return ResponseEntity.ok(createdSubscription);
	}
	

}
