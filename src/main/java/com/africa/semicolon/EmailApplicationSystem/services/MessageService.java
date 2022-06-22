package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.models.Mailbox;
import com.africa.semicolon.EmailApplicationSystem.models.Message;

public interface MessageService {
    void createMessageFolder(Mailbox mailbox);

}
