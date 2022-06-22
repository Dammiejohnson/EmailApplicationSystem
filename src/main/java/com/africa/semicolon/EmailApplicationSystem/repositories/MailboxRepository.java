package com.africa.semicolon.EmailApplicationSystem.repositories;

import com.africa.semicolon.EmailApplicationSystem.models.Mailbox;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailboxRepository extends MongoRepository<Mailbox, String> {
}
