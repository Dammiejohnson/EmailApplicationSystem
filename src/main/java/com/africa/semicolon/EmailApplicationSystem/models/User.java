package com.africa.semicolon.EmailApplicationSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Validated
@Getter
@Setter
@Document
public class User {
    @Id
    @Email
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;

    private boolean isLoggedIn;

    private List<Notification> notifications = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
