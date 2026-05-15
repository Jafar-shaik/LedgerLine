package com.jafar.smartevent.service;

import com.jafar.smartevent.entity.Event;
import com.jafar.smartevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event){
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event updateEvent(String id, Event updatedEvent){
        Event foundEvent = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));

        Optional.ofNullable(updatedEvent.getTitle())
                .ifPresent(foundEvent::setTitle);
        Optional.ofNullable(updatedEvent.getDescription()).ifPresent(foundEvent::setDescription);
        Optional.ofNullable(updatedEvent.getEventDate()).ifPresent(foundEvent::setEventDate);
        return eventRepository.save(foundEvent);
    }

    public void deleteEvent(String id){
        Event foundEvent = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not gound"));
        eventRepository.delete(foundEvent);
    }
}
