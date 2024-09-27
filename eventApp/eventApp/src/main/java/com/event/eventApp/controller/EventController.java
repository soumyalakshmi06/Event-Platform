package com.event.eventApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.event.eventApp.model.Event;
import com.event.eventApp.service.EventService;
import com.event.eventApp.service.SubscriptionService;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/Events")
public class EventController {

	
	@Autowired
	private EventService eventService;
	
	@PostMapping
	public ResponseEntity<Event> createEvent(@Validated @RequestBody Event event){
		Event createdEvent = eventService.createEvent(event);
		return ResponseEntity.ok(createdEvent);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Event>> getEventsforUser(@PathVariable Long userId,@RequestParam(required = false, defaultValue = "0")int page){
//		
		List<Subscription> subscriptions = SubscriptionService.getSubscriptionByuserId(userId);
		List<String> eventTypes= subscription.stream().map(Subscription::getEventType).collect(Collectors.toList());
		if(eventTypes.isEmpty()) {
			return new ResponseEntity<>(List.of()HttpStatus.OK);
		}
		
	}
}
