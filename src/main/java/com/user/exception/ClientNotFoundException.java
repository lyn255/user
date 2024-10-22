package com.user.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(int id) {
        super("Could not find client with id " + id);
    }
}

