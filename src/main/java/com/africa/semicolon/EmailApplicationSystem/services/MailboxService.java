package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.dtos.responses.MailBoxCreationResponse;
import com.africa.semicolon.EmailApplicationSystem.models.Mailboxes;

public interface MailboxService {
    MailBoxCreationResponse openMailBox (Mailboxes mailboxes);
}
