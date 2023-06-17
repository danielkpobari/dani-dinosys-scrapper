package com.dinosysassesment.dinosysdatascrapping.exceptions;

import com.dinosysassesment.dinosysdatascrapping.exceptions.ErrorCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    @JsonIgnore
    private int status;

    private String message;

    private String path;

    private String errorCode;

    private String infoLink;

    private Object details;

    private Date timeStamp;

    public ApiError(final int status, final String message, final String path, final ErrorCode errorCode) {
        timeStamp = new Date();
        this.status = status;
        this.message = message;
        this.path = path;
        this.errorCode = (errorCode != null) ? errorCode.toString() : null;
    }


    public ApiError(final int status, final String message, final String path, final String errorCode) {
        timeStamp = new Date();
        this.status = status;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
    }


    public ApiError(final int status, final String message, final String path) {
        timeStamp = new Date();
        this.status = status;
        this.message = message;
        this.path = path;
    }


    public ApiError(final String message, final Object details) {
        timeStamp = new Date();
        this.message = message;
        this.details = details;
    }

    public ApiError(final String message, final Object details, final String errorCode) {
        timeStamp = new Date();
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }
}
