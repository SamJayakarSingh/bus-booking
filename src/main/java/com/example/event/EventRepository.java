package com.example.event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByDateAndHall(String date, String hall);
}
