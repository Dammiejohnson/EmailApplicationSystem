package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.models.Mailbox;
import com.africa.semicolon.EmailApplicationSystem.models.Mailboxes;
import com.africa.semicolon.EmailApplicationSystem.models.Message;

public interface MailboxesService {

    void createUserMailBoxes(Mailboxes mailboxes);

    Mailbox getSenderSentBox(String senderEmail);

    Mailbox getRecipientInbox(String recipientEmail);

    Mailboxes getUserMailBoxes(String senderEmail);

    void saveMailBoxes(Mailboxes senderMailboxes);

    Message findMesssageFromInbox(String emailAddress, String s);
}
