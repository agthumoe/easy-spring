package com.achromex.core.constants;

/**
 * Constants to be use in HTTP headers.
 *
 * @author Aung Thu Moe
 * @since 1.2.0
 */
public final class HeaderConstants {
    @Deprecated
    public static final String SUCCESS = "SUCCESS";
    @Deprecated
    public static final String WARNING = "WARNING";
    @Deprecated
    public static final String ERROR = "ERROR";
    public static final String MESSAGE_TYPE = "Achromex-Message-Type";
    public static final String MESSAGE_BODY = "Achromex-Message-Body";
    public static final String PARAM = "Achromex-Param";
    public static final String TOTAL_ELEMENTS = "Achromex-Total-Elements";
    public static final String TOTAL_PAGES = "Achromex-Total-Pages";
    public static final String CURRENT_PAGE = "Achromex-Current-Page";
    public static final String ELEMENTS_PER_PAGE = "Achromex-Elements-Per-Page";
    public static final String SORT = "Achromex-Page-Sort";
    public static final String SEARCH_QUERIES = "Achromex-Search-Queries";

    /**
     * Just to prevent instantiation.
     */
    private HeaderConstants() {
    }
}
