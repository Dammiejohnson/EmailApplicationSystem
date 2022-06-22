package com.africa.semicolon.EmailApplicationSystem.services;


import com.africa.semicolon.EmailApplicationSystem.models.*;
import com.africa.semicolon.EmailApplicationSystem.repositories.MessageRepository;
import com.africa.semicolon.EmailApplicationSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageRepository messageRepository;
    @Override
    public void createMessageFolder(Mailbox mailbox) {
        messageRepository.saveAll(mailbox.getMessageList());
    }


}
