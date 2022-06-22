package com.africa.semicolon.EmailApplicationSystem.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Validated
@Getter
@Setter
public class LoginRequest {
    @Email
    private String email;
    private String password;
}
