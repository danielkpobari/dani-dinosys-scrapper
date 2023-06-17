package com.dinosysassesment.dinosysdatascrapping.exceptions.filter;

import com.dinosysassesment.dinosysdatascrapping.exceptions.DinoSysScrappingException;
import com.dinosysassesment.dinosysdatascrapping.exceptions.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class ExceptionHandlingFilter extends OncePerRequestFilter {
    /**
     * naming this differently than _objectMapper_ you give a chance your code to pass a specific object mapper by the qualifier
     * the field name will be considered as the name of the bean
     */
    private final ObjectMapper exceptionHandlerObjectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            ResponseEntity<ApiError> responseEntity = handleException(e);
            writeResponseEntity(responseEntity, response);
        }
    }

    private void writeResponseEntity(ResponseEntity<ApiError> responseEntity, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        ApiError error = responseEntity.getBody();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(responseEntity.getStatusCodeValue());
        out.print(exceptionHandlerObjectMapper.writeValueAsString(error));
        out.flush();
    }

    public ResponseEntity<ApiError> handleException(Exception e) {
        DinoSysScrappingException ex = (DinoSysScrappingException) e.getCause();
        ApiError errorResponse = ApiError
                .builder()
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode().toString())
                .status(ex.getHttpStatus().value())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
