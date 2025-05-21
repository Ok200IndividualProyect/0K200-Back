package com.ok200.demo.exceptions;

public class TechnologyAlreadyExistsException extends RuntimeException{
    public TechnologyAlreadyExistsException (String message) {
        super(message);
    }
}
