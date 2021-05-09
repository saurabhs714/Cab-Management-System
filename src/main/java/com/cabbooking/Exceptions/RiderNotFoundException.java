package com.cabbooking.Exceptions;

public class RiderNotFoundException extends RuntimeException {

    public RiderNotFoundException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
