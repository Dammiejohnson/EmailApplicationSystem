package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.models.Mailbox;
import com.africa.semicolon.EmailApplicationSystem.models.Mailboxes;
import com.africa.semicolon.EmailApplicationSystem.models.Message;
import com.africa.semicolon.EmailApplicationSystem.repositories.MailboxesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MailboxesServiceImpl implements MailboxesService{

    @Autowired
    private MailboxesRepository mailboxesRepository;

    @Autowired
    private MailboxService mailboxService;
    @Override
    public void createUserMailBoxes(Mailboxes mailboxes) {
        mailboxService.openMailBox(mailboxes);
        mailboxesRepository.save(mailboxes);
    }

    @Override
    public Mailbox getSenderSentBox(String senderEmail) {
        Optional<Mailboxes> mailboxes = mailboxesRepository.findById(senderEmail);
        return mailboxes.get().getMailboxList().get(1);
    }

    @Override
    public Mailbox getRecipientInbox(String recipientEmail) {
        Optional<Mailboxes> mailboxes = mailboxesRepository.findById(recipientEmail);
        return mailboxes.get().getMailboxList().get(0);
    }

    @Override
    public Mailboxes getUserMailBoxes(String email) {
        return mailboxesRepository.findById(email).get();
    }

    @Override
    public void saveMailBoxes(Mailboxes mailboxes) {
        mailboxService.openMailBox(mailboxes);
        mailboxesRepository.save(mailboxes);
    }

    @Override
    public Message findMesssageFromInbox(String emailAddress, String s) {
        Optional<Mailboxes> mailboxes = mailboxesRepository.findById(emailAddress);
        return null;
    }
}
