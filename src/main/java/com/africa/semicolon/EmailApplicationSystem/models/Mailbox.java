package com.africa.semicolon.EmailApplicationSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Mailbox {

    @Id
    private String id;
    private MailType mailType;
    private List<Message> messageList;

    public Mailbox(MailType mailType, List<Message> messageList) {
        this.mailType = mailType;
        this.messageList = messageList;
    }
}
