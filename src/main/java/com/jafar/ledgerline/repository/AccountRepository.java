
package com.jafar.ledgerline.repository;

import com.jafar.ledgerline.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findAllByOwnerId(String ownerId);

    Optional<Account> findByIdAndOwnerId(String id, String ownerId);

    boolean existsByAccountNumber(String accountNumber);
}
