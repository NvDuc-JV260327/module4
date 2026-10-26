package com.example.ex1.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;
    private String error;
    private String path;

    public ErrorResponse(int status, String message, String error, String path) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
        this.error = error;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
