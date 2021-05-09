package com.cabbooking.Exceptions;

public class ServiceNotAvailableException extends RuntimeException {

    public ServiceNotAvailableException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
