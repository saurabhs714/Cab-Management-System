package com.cabbooking.Exceptions;

public class LocationAlreadyExistException extends RuntimeException {

    public LocationAlreadyExistException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
