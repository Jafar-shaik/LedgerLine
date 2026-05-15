package com.jafar.smartevent.controller;

import com.jafar.smartevent.entity.Event;
import com.jafar.smartevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello jafar";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody Event event){
        eventService.saveEvent(event);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/events")
    public ResponseEntity<?> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable String id, @RequestBody Event event){
        Event updatedEvent = eventService.updateEvent(id, event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable String id){
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event deleted");
    }

}
