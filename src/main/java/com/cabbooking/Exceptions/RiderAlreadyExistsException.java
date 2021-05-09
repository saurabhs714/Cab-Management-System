package com.cabbooking.Exceptions;

public class RiderAlreadyExistsException extends RuntimeException {

    public RiderAlreadyExistsException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
