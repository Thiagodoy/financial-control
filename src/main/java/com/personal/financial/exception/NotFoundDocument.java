package com.personal.financial.exception;

public class NotFoundDocument extends RuntimeException{

    public NotFoundDocument() {
        super("Entity not found");
    }
}
