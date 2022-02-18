package edu.umd.enpm614.sample.service;

public interface AuthenticationService {
    boolean authenticateUser(String username, String password);
}
