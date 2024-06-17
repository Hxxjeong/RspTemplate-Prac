package com.example.memotest.memo.service;

import com.example.memotest.global.exception.BusinessException;
import com.example.memotest.global.exception.ErrorCode;
import com.example.memotest.memo.dto.MemoReqDto;
import com.example.memotest.memo.entity.Memo;
import com.example.memotest.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    public void create(String memo) {
        if(memo == null || memo.length() == 0) throw new BusinessException(ErrorCode.NULL_MEMO);
        Memo m = new Memo(memo);
        memoRepository.save(m);
    }

    public List<Memo> findList() {
        return memoRepository.findAll();
    }

    public Memo findOne(Long id) {
        return memoRepository.findById(id).orElseThrow(()
                -> new BusinessException(ErrorCode.ID_NOT_FOUND));
    }

    public void update(Long id, MemoReqDto memoReqDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(()
                -> new BusinessException(ErrorCode.ID_NOT_FOUND));
        if(memoReqDto.getMemo() == null || memoReqDto.getMemo().isEmpty()) throw new BusinessException(ErrorCode.NULL_MEMO);
        memo.updateMemo(memoReqDto);
        memoRepository.save(memo);
    }

    public void delete(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(()
                -> new BusinessException(ErrorCode.ID_NOT_FOUND));
        memoRepository.delete(memo);
    }
}
