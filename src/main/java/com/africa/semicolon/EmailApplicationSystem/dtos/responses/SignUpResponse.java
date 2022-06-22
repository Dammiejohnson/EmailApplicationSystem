package com.africa.semicolon.EmailApplicationSystem.dtos.responses;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {
    private String emailAddress;
    private String firstName;
    private String lastName;
}
