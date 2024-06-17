package com.example.memotest.global.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {
    // BusinessException를 통해 발생된 예외 (ID_NOT_FOUND, NULL_MEMO)
    @org.springframework.web.bind.annotation.ExceptionHandler({BusinessException.class})
    public ResponseEntity<ErrorRspDto<String>> handleBusinessException(BusinessException e, HttpServletRequest request) {
        printLog(e, request);   // 콘솔에 예외 출력
        return createErrorResponse(e.getStatusCode(), e.getHttpStatus(), e.getMessage());
    }

    // ErrorRspDto를 통한 예외 출력
    private <T> ResponseEntity<ErrorRspDto<T>> createErrorResponse(int statusCode, HttpStatus httpStatus, T errorMessage) {
        ErrorRspDto<T> errDto = new ErrorRspDto<>(statusCode, httpStatus, errorMessage);
        return ResponseEntity.status(httpStatus).body(errDto);
    }

    private void printLog(Exception e, HttpServletRequest request) {
        log.error("발생 예외: {}, 에러 메시지: {}, 요청 Method: {}, 요청 url: {}",
                e.getClass().getSimpleName(), e.getMessage(), request.getMethod(), request.getRequestURI(),
                e);
    }
}