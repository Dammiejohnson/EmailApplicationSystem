package com.africa.semicolon.EmailApplicationSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    private String messageId;
    private String senderEmail;
    private String recipientEmail;
    private String messageBody;
    private boolean isRead;
    private LocalDateTime dateTime;

}
