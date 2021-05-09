package com.cabbooking.Exceptions;

public class NoCabsAvailableException extends RuntimeException {

    public NoCabsAvailableException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
