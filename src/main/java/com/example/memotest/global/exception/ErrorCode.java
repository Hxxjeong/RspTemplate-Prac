package com.example.memotest.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NULL_MEMO(500, "메모를 입력해주세요."),
    ID_NOT_FOUND(500, "메모를 찾을 수 없습니다.");

    private int statusCode;
    private String message;
}
