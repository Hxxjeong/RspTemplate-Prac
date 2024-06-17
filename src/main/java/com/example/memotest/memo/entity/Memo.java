package com.example.memotest.memo.entity;

import com.example.memotest.memo.dto.MemoReqDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memo;

    public Memo(String memo) {
        this.memo = memo;
    }

    //  update
    public void updateMemo(MemoReqDto updatedMemo) {
        this.memo = updatedMemo.getMemo();
    }
}
