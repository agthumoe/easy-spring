package com.achromex.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception to be thrown for HTTP status: {@code 400 Bad Request}.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public class BadRequestException extends HttpStatusException {

    private static final long serialVersionUID = -3469366235536612338L;

    /**
     * Construct a BadRequest exception with HTTP status: {@code 400 Bad Request}, and a custom message.
     *
     * @param message to be shown.
     */
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
