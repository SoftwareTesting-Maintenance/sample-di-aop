package edu.umd.enpm614.sample.service;

public class InMemAuthencticationService implements AuthenticationService {
    @Override
    public boolean authenticateUser(String username, String password) {
        return password.equals("superSecretPassword");
    }
}
