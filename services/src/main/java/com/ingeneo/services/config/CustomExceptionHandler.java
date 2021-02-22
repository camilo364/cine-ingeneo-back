package com.ingeneo.services.config;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.model.exceptions.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<ApiResponse> handleConflict(RuntimeException ex, WebRequest request){
        LOG.error("Internal Server Error", ex);

        ApiResponse apiResponse = new ApiResponse(ex.getMessage(),
                null, HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiResponse);
    }

    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<ApiResponse> handleBusinessConflict(BusinessException ex, WebRequest request){
        LOG.error("Business Error {} ", ex.getMessage());

        ApiResponse apiResponse = new ApiResponse(ex.getMessage(),
                null, HttpStatus.BAD_REQUEST.value(), false);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(apiResponse);
    }
}
