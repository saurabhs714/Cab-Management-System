package com.cabbooking.Exceptions;

public class CabAlreadyExistsException extends RuntimeException {

    public CabAlreadyExistsException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
