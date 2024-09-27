package com.event.eventApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.eventApp.model.Subscription;
import com.event.eventApp.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	public Subscription subscribe(Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}

}
