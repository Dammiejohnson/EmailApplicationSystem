package com.africa.semicolon.EmailApplicationSystem.dtos.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;

}