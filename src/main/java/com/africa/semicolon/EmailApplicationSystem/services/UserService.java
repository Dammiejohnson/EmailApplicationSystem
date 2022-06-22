package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.dtos.requests.LoginRequest;
import com.africa.semicolon.EmailApplicationSystem.dtos.requests.SignUpForm;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.LoginResponse;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.SignUpResponse;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.FindUserResponse;
import com.africa.semicolon.EmailApplicationSystem.models.Message;

public interface UserService {
    SignUpResponse createAccount(SignUpForm signUpForm);

    LoginResponse logIn(LoginRequest loginRequest);

    FindUserResponse findUserByEmail(String emailAddress);

    void deleteUser(String emailAddress);

    void sendMail(Message message);


}
