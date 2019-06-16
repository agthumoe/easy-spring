package com.achromex.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception to be thrown for HTTP status: {@code 404 Not Found}.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public class NotFoundException extends HttpStatusException {

    private static final long serialVersionUID = 3972098655482086864L;

    /**
     * Construct an exception with HTTP status: {@code 404 Not Found} and, a custom message.
     *
     * @param message to be thrown.
     */
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
