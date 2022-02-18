package edu.umd.enpm614.sample;

import edu.umd.enpm614.sample.service.AuthenticationService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

public class Login {
    private final AuthenticationService authService;

    @Inject
    public Login(AuthenticationService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) throws IllegalAccessException {
        if (authService.authenticateUser(username, password)) {
            return new User();
        } else {
            throw new IllegalAccessException();
        }
    }
}
