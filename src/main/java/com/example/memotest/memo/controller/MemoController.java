package com.example.memotest.memo.controller;

import com.example.memotest.global.api.RspTemplate;
import com.example.memotest.memo.dto.MemoReqDto;
import com.example.memotest.memo.entity.Memo;
import com.example.memotest.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memos")
public class MemoController {
    private final MemoService memoService;

    // ResponseEntity
//    @PostMapping
//    public ResponseEntity<String> createMemo(@RequestBody String content) {
//        memoService.create(content);
//        return ResponseEntity.ok(content);
//    }

    // RspTemplate
    @PostMapping
    public ResponseEntity<RspTemplate<Void>> create(@RequestBody MemoReqDto memoReqDto) {
        memoService.create(memoReqDto.getMemo());
        RspTemplate<Void> rspTemplate = new RspTemplate<>(HttpStatus.CREATED, "메모 생성 완료");
        return ResponseEntity.status(HttpStatus.CREATED).body(rspTemplate);
    }

    @GetMapping
    public RspTemplate<List<Memo>> findList() {
        List<Memo> list = memoService.findList();
        return new RspTemplate<>(HttpStatus.OK, "메모 목록", list);
    }

    @GetMapping("/{id}")
    public Memo findOne(@PathVariable("id") Long id) {
        return memoService.findOne(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RspTemplate<Void>> update(@PathVariable("id") Long id, @RequestBody MemoReqDto memoReqDto) {
        memoService.update(id, memoReqDto);
        RspTemplate<Void> rspTemplate = new RspTemplate<>(HttpStatus.OK, "메모 수정 완료");
        return ResponseEntity.status(HttpStatus.OK).body(rspTemplate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RspTemplate<Void>> delete(@PathVariable("id") Long id) {
        memoService.delete(id);
        RspTemplate<Void> rspTemplate = new RspTemplate<>(HttpStatus.OK, "메모 삭제 완료");
        return ResponseEntity.status(HttpStatus.OK).body(rspTemplate);
    }
}
