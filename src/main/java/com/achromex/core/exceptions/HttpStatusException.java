package com.achromex.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception thrown in condition if the application requires to provide HTTP status response code.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public class HttpStatusException extends RuntimeException {

    private static final long serialVersionUID = -8797422003793301779L;

    private final HttpStatus httpStatus;
    private final String message;

    /**
     * Construct an exception with provided HTTP status and a message.
     *
     * @param httpStatus response code to identify the problem.
     * @param message    to be shown.
     */
    public HttpStatusException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
