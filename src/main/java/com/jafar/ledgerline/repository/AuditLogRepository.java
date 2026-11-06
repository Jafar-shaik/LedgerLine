
package com.jafar.ledgerline.repository;

import com.jafar.ledgerline.model.AuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuditLogRepository
        extends MongoRepository<AuditLog, String> {

    List<AuditLog> findByActorIdOrderByCreatedAtDesc(
            String actorId
    );

    List<AuditLog> findByResourceTypeAndResourceId(
            String resourceType,
            String resourceId
    );
}
