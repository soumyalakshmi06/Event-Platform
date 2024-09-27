package com.event.eventApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.eventApp.model.Event;
import com.event.eventApp.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	
	public Event createEvent(Event event) {
		event.setTimeStamp(LocalDate.now());
		return eventRepository.save(event);
	}

	public  List<Event> getRecentEvents(List<String>eventTypes){
		
		return eventRepository.findByTypeinOrderByTimestamp(eventTypes);
		
	}

	
}