package com.africa.semicolon.EmailApplicationSystem.dtos.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailBoxCreationResponse {
    private boolean isSuccessful;
    private String message;
}
