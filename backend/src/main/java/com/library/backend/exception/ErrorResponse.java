package com.library.backend.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {

    private final boolean success;
    private final String message;
    private final String errorCode;
    private final int status;
    private final String path;
    private final LocalDateTime timestamp;
    private final Map<String, String> fieldErrors;

    public ErrorResponse(
            String message,
            String errorCode,
            int status,
            String path
    ) {
        this.success = false;
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.path = path;
        this.timestamp = LocalDateTime.now();
        this.fieldErrors = null;
    }

    public ErrorResponse(
            String message,
            String errorCode,
            int status,
            String path,
            Map<String, String> fieldErrors
    ) {
        this.success = false;
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.path = path;
        this.timestamp = LocalDateTime.now();
        this.fieldErrors = fieldErrors;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}