package com.africa.semicolon.EmailApplicationSystem.repositories;

import com.africa.semicolon.EmailApplicationSystem.models.Message;
import com.africa.semicolon.EmailApplicationSystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

}
