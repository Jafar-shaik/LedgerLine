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

@Document(collection = "ledger_entries")
@CompoundIndex(
        name = "account_created_idx",
        def = "{'accountId': 1, 'createdAt': -1}"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LedgerEntry {

    @Id
    private String id;

    @Indexed
    private String transactionId;

    private String accountId;

    private EntryType entryType;

    private EntryDirection direction;

    private long amountPaise;

    private String description;

    private Instant createdAt;
}