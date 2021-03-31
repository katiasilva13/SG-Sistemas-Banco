package com.sg.banco.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String title;
    private int status;
    private String details;
    private String developerMessage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public static final class Builder {
        private Date timestamp;
        private String title;
        private int status;
        private String details;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder timestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ExceptionResponse build() {
            ExceptionResponse exceptionResponse = new ExceptionResponse();
            exceptionResponse.setTitle(title);
            exceptionResponse.setStatus(status);
            exceptionResponse.setDetails(details);
            exceptionResponse.setTimestamp(timestamp);
            exceptionResponse.setDeveloperMessage(developerMessage);
            return exceptionResponse;
        }
    }
}



/*
ExceptionResponse
CustomizedResponseEntityExceptionHandler
 */