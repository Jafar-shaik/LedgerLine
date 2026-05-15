package com.jafar.smartevent.repository;

import com.jafar.smartevent.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String > {

}
