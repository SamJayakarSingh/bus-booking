package com.example.event;

import jakarta.persistence.*;

@Entity
@Table(name="registration")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="Place of visit")
    private String name;
	@Column(name="strength")
    private String attendees;
	@Column(name="time")
    private String time;
	@Column(name="date")
    private String date;
	@Column(name="Travels name")
    private String hall;
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAttendees() {
		return attendees;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time= time;
	}

}
