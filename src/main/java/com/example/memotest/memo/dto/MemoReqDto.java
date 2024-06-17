package com.example.memotest.memo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class MemoReqDto {
    @NotEmpty(message = "메모를 입력해주세요.")
    private String memo;
}
