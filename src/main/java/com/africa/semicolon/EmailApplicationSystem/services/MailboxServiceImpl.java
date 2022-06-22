package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.dtos.responses.MailBoxCreationResponse;
import com.africa.semicolon.EmailApplicationSystem.models.Mailbox;
import com.africa.semicolon.EmailApplicationSystem.models.Mailboxes;
import com.africa.semicolon.EmailApplicationSystem.repositories.MailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MailboxServiceImpl implements MailboxService{

    @Autowired
    private MailboxRepository mailboxRepository;

    @Autowired
    private MessageService messageService;
    @Override
    public MailBoxCreationResponse openMailBox(Mailboxes mailboxes) {
        for ( Mailbox mailbox : mailboxes.getMailboxList()) {
            messageService.createMessageFolder(mailbox);
            mailboxRepository.save(mailbox);
        }
        return null;
    }
}
