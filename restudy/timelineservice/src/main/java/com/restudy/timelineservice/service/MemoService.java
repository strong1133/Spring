package com.restudy.timelineservice.service;

import com.restudy.timelineservice.domain.Memo;
import com.restudy.timelineservice.domain.MemoRepository;
import com.restudy.timelineservice.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        memo.update(memoRequestDto);
        return memo.getId();
    }
}
