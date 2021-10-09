package com.personal.financial.exception;

public class TokenInvalidException extends RuntimeException {

    public TokenInvalidException() {
        super("Token inválido!");
    }
}
