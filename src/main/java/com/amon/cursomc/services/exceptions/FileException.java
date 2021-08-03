package com.amon.cursomc.services.exceptions;

public class FileException extends RuntimeException {

    private static final long serialVersionUID = 4873480359725541289L;

    public FileException(String msg) {
        super(msg);
    }

    public FileException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
