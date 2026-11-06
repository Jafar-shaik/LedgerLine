package com.jafar.ledgerline.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "idempotency_keys")
@CompoundIndex(
        name = "user_key_unique_idx",
        def = "{'userId': 1, 'key': 1}",
        unique = true
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdempotencyKey {

    @Id
    private String id;

    private String userId;

    private String key;

    private String requestHash;

    private IdempotencyStatus status;

    private String transactionId;

    private Instant createdAt;
}
