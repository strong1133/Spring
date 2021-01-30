package com.restudy.week03.controller;

import com.restudy.week03.domain.Memo;
import com.restudy.week03.domain.MemoRepository;
import com.restudy.week03.domain.MemoRequestDto;
import com.restudy.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> getMemo() {
        return memoRepository.findByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        return memoService.update(id, memoRequestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
