package com.achromex.core.utils;

import com.achromex.core.constants.MessageType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Iterator;

import static com.achromex.core.constants.HeaderConstants.*;

/**
 * This is a builder to build http header.
 *
 * @author Aung Thu Moe
 * @since 1.2.0
 */
public final class HttpHeaderBuilder {
    private final HttpHeaders httpHeaders = new HttpHeaders();

    public static HttpHeaderBuilder getHeaderBuilder() {
        return new HttpHeaderBuilder();
    }

    /**
     * Set specific content-type to http headers.
     *
     * @param mediaType quality parameters as defined in the HTTP specification.
     * @return this builder.
     */
    public HttpHeaderBuilder setContentType(MediaType mediaType) {
        this.httpHeaders.setContentType(mediaType);
        return this;
    }

    /**
     * Set the specific message type to http headers.
     *
     * @param messageType type of message, SUCCESS, ERROR or WARNING.
     * @return this builder.
     * @see {@link com.achromex.core.constants.MessageType}
     */
    public HttpHeaderBuilder addMessageType(MessageType messageType) {
        this.httpHeaders.add(MESSAGE_TYPE, messageType.toString());
        return this;
    }

    /**
     * Added messageType with message to http headers.
     *
     * @param messageType type of message, SUCCESS, ERROR or WARNING.
     * @param message     to be include in the header.
     * @return this builder.
     * @see {@link com.achromex.core.constants.MessageType}
     */
    public HttpHeaderBuilder addMessage(MessageType messageType, String message) {
        this.httpHeaders.add(MESSAGE_TYPE, messageType.toString());
        this.httpHeaders.add(MESSAGE_BODY, message);
        return this;
    }

    /**
     * Added one parameter to http header.
     *
     * @param param to be added.
     * @return this builder.
     */
    public HttpHeaderBuilder addParam(String param) {
        this.httpHeaders.add(PARAM, param);
        return this;
    }

    /**
     * Added list of parameters to http header.
     *
     * @param params to be added.
     * @return this builder.
     */
    public HttpHeaderBuilder addParam(String... params) {
        for (String param : params) {
            addParam(param);
        }
        return this;
    }

    /**
     * Added pagination information to http header.
     *
     * @param page Pagination information to be added.
     * @return this builder.
     */
    public HttpHeaderBuilder addPagination(Page<?> page) {
        this.httpHeaders.add(TOTAL_ELEMENTS, "" + page.getTotalElements());
        this.httpHeaders.add(TOTAL_PAGES, "" + page.getTotalPages());
        this.httpHeaders.add(CURRENT_PAGE, "" + page.getNumber());
        this.httpHeaders.add(ELEMENTS_PER_PAGE, "" + page.getSize());
        return this.addSortQueries(page.getSort());
    }

    /**
     * Add search queries to http header.
     *
     * @param searchQueries to be added.
     * @return this builder.
     */
    public HttpHeaderBuilder addSearchQueries(String searchQueries) {
        this.httpHeaders.add(SEARCH_QUERIES, searchQueries);
        return this;
    }

    /**
     * Add sort queries to http header.
     *
     * @param sort Sort queries to be added.
     * @return this builder.
     */
    public HttpHeaderBuilder addSortQueries(Sort sort) {
        this.httpHeaders.add(SORT, sort.toString());
        return this;
    }

    /**
     * This method build and return the http headers.
     *
     * @return the composed http header.
     */
    public HttpHeaders build() {
        return this.httpHeaders;
    }
}
