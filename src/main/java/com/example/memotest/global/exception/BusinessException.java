package com.example.memotest.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// 비즈니스 로직 상 예외
@Getter
public class BusinessException extends RuntimeException {
    private final int statusCode;
    private final HttpStatus httpStatus;

    // ErrorCode를 받아 예외 처리
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage()); // throwable의 getMessage()
        this.statusCode = errorCode.getStatusCode();
        this.httpStatus = HttpStatus.valueOf(errorCode.getStatusCode());
    }
}
