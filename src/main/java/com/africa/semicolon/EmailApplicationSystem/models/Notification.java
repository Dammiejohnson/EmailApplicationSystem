package com.africa.semicolon.EmailApplicationSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification {
    @Id
    private String id;
    private String title;
    private String messageId;
    private LocalDateTime localDateTime;

    public Notification(String title, String messageId, LocalDateTime localDateTime) {
        this.title = title;
        this.messageId = messageId;
        this.localDateTime = localDateTime;
    }
}
