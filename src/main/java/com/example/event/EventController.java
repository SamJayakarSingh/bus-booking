package com.example.event;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/main")
    public String openIndex() {
        return "index.html";
    }
    @GetMapping("/adminlogin")
    public String loginIndex() {
        return "adminlogin.html";
    }
    @GetMapping("/booking")
    public String bookIndex() {
        return "NewFile.html";
    }
    @PostMapping("/adlog")
    public String adminlogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if ("saravana".equals(username) && "123".equals(password)) {
            List<Event> events = eventRepository.findAll(); // Fetch all events from the database
            model.addAttribute("events", events);
            return "c"; // Make sure this matches the file name in your templates directory
        }
        return "redirect:/main"; // Redirect back to the main page if login fails
    }


    @PostMapping("/save")
    public String saveEventDetail(@RequestParam("event-name") String name,
                                  @RequestParam("attendees") String attendees,
                                  @RequestParam("date") String date,
                                  @RequestParam("time") String time,
                                  @RequestParam("event-hall") String hall
 ) {
    	List<Event> eventsOnDate = eventRepository.findByDateAndHall(date, hall);
        if (!eventsOnDate.isEmpty()) {
            return "redirect:/success.html"; // Redirect to error page or return an error message
        }
        Event eventDetail = new Event();
        eventDetail.setName(name);
        eventDetail.setAttendees(attendees);
        eventDetail.setDate(date);
        eventDetail.setTime(time);
        eventDetail.setHall(hall);
        eventRepository.save(eventDetail);
        return "success.html"; // Redirect to a success page
    }
}
