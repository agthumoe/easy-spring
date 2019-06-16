package com.achromex.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception to be thrown for HTTP status: {@code 403 Forbidden}.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public class ForbiddenException extends HttpStatusException {

    private static final long serialVersionUID = -3469366235536612338L;

    /**
     * Construct an exception with HTTP status: {@code 403 Forbidden} and, a custom message.
     *
     * @param message to be shown.
     */
    public ForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
