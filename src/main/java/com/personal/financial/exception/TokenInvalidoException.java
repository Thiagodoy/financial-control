package com.personal.financial.exception;

public class TokenInvalidoException extends RuntimeException {

    public TokenInvalidoException() {
        super("Token inválido!");
    }
}
