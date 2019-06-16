package com.achromex.core.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerException extends HttpStatusException {
    private static final long serialVersionUID = 8696504842196861173L;

    /**
     * Construct an exception with HTTP status 500 and a message.
     *
     * @param message to be shown.
     */
    public InternalServerException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
