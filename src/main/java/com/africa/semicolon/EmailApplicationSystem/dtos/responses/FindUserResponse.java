package com.africa.semicolon.EmailApplicationSystem.dtos.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindUserResponse {
    private String emailAddress;
    private String message;
}
