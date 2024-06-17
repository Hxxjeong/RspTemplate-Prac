package com.example.memotest.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorRspDto<T> {
    private int statusCode;
    private String httpStatus;
    private T errorMessage;

    public ErrorRspDto(int statusCode, HttpStatus httpStatus, T errorMessage) {
        this.statusCode = statusCode;
        this.httpStatus = httpStatus.getReasonPhrase(); // 상태 코드의 번호: 400번대, 500번대 등
        this.errorMessage = errorMessage;
    }
}
