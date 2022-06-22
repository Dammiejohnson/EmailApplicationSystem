package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.dtos.requests.LoginRequest;
import com.africa.semicolon.EmailApplicationSystem.dtos.requests.SignUpForm;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.LoginResponse;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.SignUpResponse;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.FindUserResponse;
import com.africa.semicolon.EmailApplicationSystem.exceptions.EmailAppException;
import com.africa.semicolon.EmailApplicationSystem.models.*;
import com.africa.semicolon.EmailApplicationSystem.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailboxesService mailboxesService;

    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public SignUpResponse createAccount(SignUpForm signUpForm) {
        Optional<User> userOptional = userRepository.findById(signUpForm.getEmailAddress());
        if(userOptional.isPresent()) throw new EmailAppException("User already exists");
        User user = new User();
        modelMapper.map(signUpForm, user);
        User savedUser = userRepository.save(user);
        Mailboxes mailboxes = new Mailboxes(savedUser.getEmailAddress(), new ArrayList<>());
        mailboxesService.createUserMailBoxes(mailboxes);
        log.info("saved user ---> {} ", savedUser);
        SignUpResponse response = new SignUpResponse();
        modelMapper.map(savedUser, response);
        return response;
    }

    @Override
    public LoginResponse logIn(LoginRequest loginRequest) {
        User user = userRepository.findById(loginRequest.getEmail())
                .orElseThrow(() -> new EmailAppException("User not found"));
        if(!user.isLoggedIn()) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                User savedUser = userRepository.save(user);
                user.setLoggedIn(true);
                LoginResponse response = new LoginResponse();
                modelMapper.map(loginRequest, response);
                response.setMessage("Welcome " + savedUser.getEmailAddress());
                response.setSuccessful(true);
                return response;
            } else throw new EmailAppException("Invalid Details");
        }
        return new LoginResponse("user already logged in");
    }

    @Override
    public FindUserResponse findUserByEmail(String emailAddress) {
       User user = userRepository.findById(emailAddress).orElseThrow(() -> new EmailAppException("User not found"));
       FindUserResponse findUserResponse = new FindUserResponse();
       modelMapper.map(user, findUserResponse);
        return findUserResponse;
    }

    @Override
    public void deleteUser(String emailAddress) {
        User user = userRepository.findById(emailAddress).orElseThrow(() -> new EmailAppException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public void sendMail(Message message) {
        Mailboxes senderMailboxes = mailboxesService.getUserMailBoxes(message.getSenderEmail());
        senderMailboxes.getMailboxList().get(1).getMessageList().add(message);
        mailboxesService.saveMailBoxes(senderMailboxes);
        Mailboxes recipientMailBoxes = mailboxesService.getUserMailBoxes(message.getRecipientEmail());
        recipientMailBoxes.getMailboxList().get(0).getMessageList().add(message);
        mailboxesService.saveMailBoxes(recipientMailBoxes);

        User recipient = userRepository.findById(message.getRecipientEmail()).get();

        //recipient.getNotifications().add(new Notification("Yor have a new notification from " + message.getSenderEmail(), message));

        userRepository.save(recipient);
    }
}
