package com.FlooringMastery.dao;

public class NoOrdersException extends Exception {
    public NoOrdersException(String message) {
        super(message);
    }

    public NoOrdersException(String message, Throwable cause)  {
        super(message, cause);
    }
}
