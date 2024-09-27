package com.event.eventApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.eventApp.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByTypeinOrderByTimestamp(List<String> types);


}
