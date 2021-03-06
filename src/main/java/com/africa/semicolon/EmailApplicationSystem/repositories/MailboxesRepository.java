package com.africa.semicolon.EmailApplicationSystem.repositories;

import com.africa.semicolon.EmailApplicationSystem.models.Mailboxes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailboxesRepository extends MongoRepository<Mailboxes, String> {
}
