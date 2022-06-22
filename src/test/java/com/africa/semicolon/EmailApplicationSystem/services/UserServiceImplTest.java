package com.africa.semicolon.EmailApplicationSystem.services;

import com.africa.semicolon.EmailApplicationSystem.dtos.requests.LoginRequest;
import com.africa.semicolon.EmailApplicationSystem.dtos.requests.SignUpForm;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.LoginResponse;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.SignUpResponse;
import com.africa.semicolon.EmailApplicationSystem.dtos.responses.FindUserResponse;
import com.africa.semicolon.EmailApplicationSystem.models.Mailbox;
import com.africa.semicolon.EmailApplicationSystem.models.Mailboxes;
import com.africa.semicolon.EmailApplicationSystem.models.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MailboxesService mailboxesService;

    SignUpForm signUpForm;
    SignUpForm signUpForm2;


    @BeforeEach
    void setUp() {
        signUpForm = SignUpForm.builder()
                .firstName("Oluwadamilola")
                .lastName("Sanni")
                .emailAddress("Sannijohn@gmail.com")
                .password("Damilola@2")
                .build();

        signUpForm2 = SignUpForm.builder()
                .firstName("Chibuife")
                .lastName("Jerry")
                .emailAddress("IntelliJ@gmail.com")
                .password("Jerryman@2")
                .build();
    }

    @Test
    void testThatUserCanBeCreated(){
        SignUpResponse signUpResponse = userService.createAccount(signUpForm);
        assertThat(signUpResponse.getEmailAddress()).isNotNull();
        assertThat(signUpResponse.getFirstName()).isEqualTo("Oluwadamilola");
    }

    @Test
    void testThatUserCanLogin(){
        userService.createAccount(signUpForm);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(signUpForm.getEmailAddress());
        loginRequest.setPassword(signUpForm.getPassword());
        LoginResponse response = userService.logIn(loginRequest);
        assertThat(response.isSuccessful()).isEqualTo(true);
    }

    @Test
    void testThatMessageCanBeSent(){
        SignUpResponse signUpResponse = userService.createAccount(signUpForm);
        SignUpResponse signUpResponse2 = userService.createAccount(signUpForm2);
        Message message = new Message();
        message.setDateTime(LocalDateTime.now());
        message.setRecipientEmail(signUpResponse2.getEmailAddress());
        message.setSenderEmail(signUpResponse.getEmailAddress());
        userService.sendMail(message);
        Mailbox inbox = mailboxesService.getRecipientInbox(signUpResponse2.getEmailAddress());
        assertThat(inbox.getMessageList().size()).isEqualTo(1);
    }



    @Test
    void testThatMessageCanBeFound(){
        SignUpResponse signUpResponse = userService.createAccount(signUpForm);
        SignUpResponse signUpResponse2 = userService.createAccount(signUpForm2);
        Message message = new Message();
        message.setDateTime(LocalDateTime.now());
        message.setRecipientEmail(signUpResponse2.getEmailAddress());
        message.setSenderEmail(signUpResponse.getEmailAddress());
        message.setMessageBody("Dami is going to Interswitch");
        userService.sendMail(message);
        Message message1 = mailboxesService.findMesssageFromInbox(signUpResponse2.getEmailAddress(), "Sannijohn@gmail.com");

    }

    @Test
    void testThatUserCanBeFound (){
        SignUpResponse signUpResponse = userService.createAccount(signUpForm);
        FindUserResponse findUserResponse = userService.findUserByEmail(signUpResponse.getEmailAddress());
        assertThat(findUserResponse.getEmailAddress()).isEqualTo("Sannijohn@gmail.com");
    }

    @AfterEach
    void tearDown() {
        userService.deleteUser(signUpForm.getEmailAddress());
    }
}