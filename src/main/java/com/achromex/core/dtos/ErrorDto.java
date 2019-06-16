package com.achromex.core.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * ErrorDTO to represent HTTP error code and message.
 *
 * @author Aung Thu Moe
 * @since 1.2.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorDto implements Serializable {

    private static final long serialVersionUID = -7966551902056922722L;

    private int httpStatus;
    private String message;

    /**
     * Construct an object which contains httpStatus code and error message.
     *
     * @param httpStatus HttpStatus code.
     * @param message    to be build.
     */
    public ErrorDto(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
