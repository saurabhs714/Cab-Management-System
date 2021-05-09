package com.cabbooking.Exceptions;

public class CabNotFoundException extends RuntimeException {

    public CabNotFoundException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
