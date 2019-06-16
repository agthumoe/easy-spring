package com.achromex.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception to be thrown for HTTP status: {@code 403 Forbidden}.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public class UnauthorizedException extends HttpStatusException {

    private static final long serialVersionUID = -3469366235536612338L;

    /**
     * Construct an exception with provided HTTP status and, a custom message.
     *
     * @param message to be shown.
     */
    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
