package org.example.api.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.core.common.exception.BusinessException;
import org.example.core.common.response.ApiResponse;
import org.example.core.common.response.ResponseCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e) {
        log.warn("BusinessException: {}", e.getMessage(), e);
        return ResponseEntity.badRequest()
                .body(ApiResponse.of(ResponseCode.UNKNOWN_ERROR, null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
        log.error("Exception: {}", e.getMessage(), e);
        return ResponseEntity.internalServerError()
                .body(ApiResponse.of(ResponseCode.UNKNOWN_ERROR, null));
    }
}
