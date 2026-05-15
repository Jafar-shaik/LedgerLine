package com.jafar.smartevent.entity;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "events")
public class Event {

    @Id
    private String id;

    @NotNull
    private String title;
    private String description;

    @NotNull
    private LocalDateTime eventDate;
    private LocalDateTime createdDate = LocalDateTime.now();
}
