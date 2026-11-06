package com.jafar.ledgerline.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "accounts")
@CompoundIndex(
        name = "owner_created_idx",
        def = "{'ownerId': 1, 'createdAt': -1}"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    private String id;

    @Indexed(unique = true)
    private String accountNumber;

    private String ownerId;

    private AccountType accountType;

    private long balancePaise;

    private String currency;

    private AccountStatus status;

    private Instant createdAt;

    private Instant updatedAt;
}
