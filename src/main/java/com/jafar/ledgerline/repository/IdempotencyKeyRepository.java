
package com.jafar.ledgerline.repository;

import com.jafar.ledgerline.model.IdempotencyKey;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IdempotencyKeyRepository
        extends MongoRepository<IdempotencyKey, ObjectId> {

    Optional<IdempotencyKey> findByUserIdAndKey(
            ObjectId userId,
            String key
    );
}
