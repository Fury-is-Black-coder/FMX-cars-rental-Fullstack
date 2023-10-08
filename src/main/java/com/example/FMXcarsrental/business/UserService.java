package com.example.FMXcarsrental.business;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String generateLogin(String firstName, String lastName) {
        return firstName.substring(0, 1).toLowerCase() + "." + lastName.toLowerCase();
    }
}
