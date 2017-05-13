package com.domain.spring.exception;

/**
 *
 * @author wszybisty
 */
public class ErrorInfo {
    public final String url;
    public final String code;

    public ErrorInfo(CharSequence url, String code) {
        this.url = url.toString();
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }
}
