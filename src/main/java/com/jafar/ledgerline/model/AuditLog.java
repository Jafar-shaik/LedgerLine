package com.jafar.ledgerline.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "audit_logs")
@CompoundIndex(
        name = "actor_created_idx",
        def = "{'actorId': 1, 'createdAt': -1}"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    private String id;

    private String actorId;

    private String action;

    private String resourceType;

    private String resourceId;

    private String ipAddress;

    private Instant createdAt;
}