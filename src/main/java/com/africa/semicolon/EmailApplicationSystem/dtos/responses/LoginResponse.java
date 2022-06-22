package com.africa.semicolon.EmailApplicationSystem.dtos.responses;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {
    private String email;
    private boolean isSuccessful;
    private  String message;

    public LoginResponse(String message) {
        this.message = message;
    }
}
