package com.amon.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 4873480359725541289L;

    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
