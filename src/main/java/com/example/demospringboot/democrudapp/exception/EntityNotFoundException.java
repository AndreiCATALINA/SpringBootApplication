package com.example.demospringboot.democrudapp.exception;

//in case I need it (I did not use it yet)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
