package com.amon.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4873480359725541289L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
