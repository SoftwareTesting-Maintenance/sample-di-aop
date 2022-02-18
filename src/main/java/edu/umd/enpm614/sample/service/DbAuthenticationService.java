package edu.umd.enpm614.sample.service;

public class DbAuthenticationService implements AuthenticationService {
    @Override
    public boolean authenticateUser(String username, String password) {
        return username.equals("user") && password.equals("superSecretPassword");
    }
}
