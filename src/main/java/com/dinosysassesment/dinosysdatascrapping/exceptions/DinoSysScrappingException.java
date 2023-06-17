package com.dinosysassesment.dinosysdatascrapping.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class DinoSysScrappingException extends RuntimeException {

    protected HttpStatus httpStatus;

    private ErrorCode errorCode;

    private String infoLink;

    private String metadata;

    public DinoSysScrappingException(final String message) {
        super(message);
    }

    public DinoSysScrappingException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public DinoSysScrappingException(final String message, final HttpStatus httpStatus, final ErrorCode errorCode) {
        this(message, httpStatus);
        this.errorCode = errorCode;
    }

    public DinoSysScrappingException(final String message, final HttpStatus httpStatus, final String metadata) {
        this(message, httpStatus);
        this.metadata = metadata;
    }

    public DinoSysScrappingException(String message, HttpStatus httpStatus, ErrorCode errorCode, String metadata) {
        this(message, httpStatus, errorCode);
        this.metadata = metadata;
    }
}
