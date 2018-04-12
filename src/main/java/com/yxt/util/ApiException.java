package com.yxt.util;

/**
 * @author luoxiaozhu
 * @date 2018-1-31-0031 17:36
 */
public class ApiException extends RuntimeException {
    private final String errorKey;
    private final Object[] values;

    /**
     * Constructor
     *
     * @param errorKey String
     * @param values   Object...
     */
    public ApiException(final String errorKey, final Object... values) {
        this.errorKey = errorKey;
        this.values = values;
    }

    /**
     * Constructor
     *
     * @param errorKey String
     */
    public ApiException(final String errorKey) {
        this(errorKey, new Object[0]);
    }

    /**
     * getErrorKey
     *
     * @return String
     */
    public String getErrorKey() {
        return errorKey;
    }

    /**
     * getValues
     *
     * @return Object[]
     */
    public Object[] getValues() {
        return values;
    }
}
