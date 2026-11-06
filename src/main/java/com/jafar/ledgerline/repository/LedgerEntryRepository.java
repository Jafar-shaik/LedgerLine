
package com.jafar.ledgerline.repository;

import com.jafar.ledgerline.model.LedgerEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LedgerEntryRepository
        extends MongoRepository<LedgerEntry, ObjectId> {

    List<LedgerEntry> findByAccountIdOrderByCreatedAtDesc(
            ObjectId accountId
    );

    List<LedgerEntry> findByTransactionId(
            ObjectId transactionId
    );
}
