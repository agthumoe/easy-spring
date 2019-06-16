package com.achromex.core.handlers;

import com.achromex.core.dtos.ErrorDto;
import com.achromex.core.dtos.ValidationErrorDto;
import com.achromex.core.exceptions.HttpStatusException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.achromex.core.constants.MessageType.ERROR;
import static com.achromex.core.utils.HttpHeaderBuilder.getHeaderBuilder;

/**
 * Exception handler to handle httpStatus exception.
 *
 * <p>
 * One should extends this exception handler and add class level annotation like the following.
 * <code>
 * &#64;RestControllerAdvice(basePackage = "com.example.package")
 * </code>
 * </p>
 * <br />
 * <p>
 * And override handleHttpStatusException method and add method level annotation like the following.
 * <code>
 * &#64;ExceptionHandler(value = HttpStatusException.class)
 * </code>
 * </p>
 */
public class HttpStatusExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle HttpStatusException.<br />
     * <p>
     * And override handleHttpStatusException method and add method level annotation like the following.
     * <code>
     * &#64;ExceptionHandler(value = HttpStatusException.class)
     * </code>
     * </p>
     *
     * @param exception to be catched.
     * @return ResponseEntity as return value to controller.
     */
    protected ResponseEntity<?> handleHttpStatusException(HttpStatusException exception) {
        final HttpHeaders httpHeaders = getHeaderBuilder()
            .addMessage(ERROR, exception.getMessage())
            .build();

        return ResponseEntity
            .status(exception.getHttpStatus())
            .headers(httpHeaders)
            .body(new ErrorDto(exception.getHttpStatus().value(), exception.getMessage()));
    }

    /**
     * To handle validation error exception.
     *
     * @param ex      Exception to be catched.
     * @param headers Http Headers.
     * @param status  Http status.
     * @param request current request to handle.
     * @return ResponseEntity as return value to controller.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
        WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        final ValidationErrorDto dto = new ValidationErrorDto(400);
        if (bindingResult.hasFieldErrors()) {
            // default message is error code.
            bindingResult.getFieldErrors()
                .forEach(error -> dto.getMessages().add(error.getDefaultMessage()));
        }

        final HttpHeaders httpHeaders = getHeaderBuilder()
            .addMessage(ERROR, "Validation Failed.")
            .build();

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .headers(httpHeaders)
            .body(dto);
    }
}
