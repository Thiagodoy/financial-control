package com.personal.financial.resource.response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppErrorResponse {

    private final String apiVersion;
    private final ErrorBlock error;

    public AppErrorResponse(final String apiVersion, final String code, final String message, final String domain,
                            final String reason, final String errorMessage) {
        this.apiVersion = apiVersion;
        this.error = new ErrorBlock(code, message, domain, reason, errorMessage);
    }

    public static AppErrorResponse fromDefaultAttributeMap(final String apiVersion,
                                                            final Map<String, Object> defaultErrorAttributes) {
        // original attribute values are documented in org.springframework.boot.web.servlet.error.DefaultErrorAttributes
        return new AppErrorResponse(
                apiVersion,
                ((Integer) defaultErrorAttributes.get("status")).toString(),
                (String) defaultErrorAttributes.getOrDefault("message", "no message available"),
                (String) defaultErrorAttributes.getOrDefault("path", "no domain available"),
                (String) defaultErrorAttributes.getOrDefault("error", "no reason available"),
                (String) defaultErrorAttributes.get("message")
        );
    }

    public AppErrorResponse(final String apiVersion, final String code, final String message, final List<Error> errors) {
        this.apiVersion = apiVersion;
        this.error = new ErrorBlock(code, message, errors);
    }

    public Map<String, Object> toAttributeMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("apiVersion", apiVersion);
        map.put("error", error);
        return map;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public ErrorBlock getError() {
        return error;
    }

    private static final class ErrorBlock {

        private final String code;
        private final String message;
        private final List<Error> errors;

        public ErrorBlock(final String code, final String message, final String domain,
                          final String reason, final String errorMessage) {
            this.code = code;
            this.message = message;
            this.errors = Arrays.asList(
                    new Error(domain, reason, errorMessage)
            );
        }

        public ErrorBlock(final String code, final String message, List<Error> errors) {
            this.code = code;
            this.message = message;
            this.errors = errors;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public List<Error> getErrors() {
            return errors;
        }

    }

    public static final class Error {
        private final String domain;
        private final String reason;
        private final String message;

        public Error(final String domain, final String reason, final String message) {
            this.domain = domain;
            this.reason = reason;
            this.message = message;
        }

        public String getDomain() {
            return domain;
        }

        public String getReason() {
            return reason;
        }

        public String getMessage() {
            return message;
        }
    }
}
