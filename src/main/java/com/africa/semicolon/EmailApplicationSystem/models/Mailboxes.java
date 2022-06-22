package com.africa.semicolon.EmailApplicationSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Mailboxes {

    @Id
    private String userEmail;
    private List<Mailbox> mailboxList;

    public Mailboxes(String userEmail, List<Mailbox> mailboxList) {
        this.userEmail = userEmail;
        if(mailboxList == null) {
            mailboxList = new ArrayList<>();
        }
        this.mailboxList = mailboxList;
        this.mailboxList.add(new Mailbox(MailType.INBOX, new ArrayList<>()));
        this.mailboxList.add(new Mailbox(MailType.SENT, new ArrayList<>()));
    }
}
