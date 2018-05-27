package com.github.dgarcia202.springcrm.exceptions;

public class CrmException extends Exception {

    public CrmException(String message) {
        super(message);
    }

    public CrmException(String message, Throwable cause) {
        super(message, cause);
    }
}
