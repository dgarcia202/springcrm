package com.github.dgarcia202.springcrm.exceptions;

public class CrmItemNotFoundException extends CrmException {
    public CrmItemNotFoundException() {
        super("Item not found");
    }
}
