package com.amon.cursomc.services.exceptions;

public class AuthorizationException extends RuntimeException {

    private static final long serialVersionUID = 4873480359725541289L;

    public AuthorizationException(String msg) {
        super(msg);
    }

    public AuthorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
