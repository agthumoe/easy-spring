package com.achromex.core.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DTO to represent validation error on HTTP.
 *
 * @author Aung Thu Moe
 * @since 1.2.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ValidationErrorDto implements Serializable {

    private static final long serialVersionUID = 7720978613917961780L;

    private int httpStatus;
    private List<String> messages = new ArrayList<>();

    public ValidationErrorDto() {
    }

    public ValidationErrorDto(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ValidationErrorDto(int httpStatus, String... messages) {
        this.httpStatus = httpStatus;
        this.messages = Arrays.asList(messages);
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
