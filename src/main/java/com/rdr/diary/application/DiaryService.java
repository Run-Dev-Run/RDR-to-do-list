package com.rdr.diary.application;

import com.rdr.common.exception.ErrorMessage;
import com.rdr.diary.converter.DiaryConverter;
import com.rdr.diary.domain.Diary;
import com.rdr.diary.bundle.*;
import com.rdr.diary.infrastructure.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final DiaryConverter diaryConverter;

    @Transactional
    public DiaryCreateBundle.Response create(DiaryCreateBundle.Request requestBundle) {
        Diary diary = diaryRepository.save(diaryConverter.toDiary(requestBundle));
        return diaryConverter.toDiaryCreateBundleResponse(diary);
    }

    @Transactional(readOnly = true)
    public DiaryFindAllBundle.Response find() {
        List<Diary> diaries = diaryRepository.findAll();
        return diaryConverter.toDiaryFindAllBundleResponse(diaries);
    }

    @Transactional(readOnly = true)
    public DiaryFindBundle.Response find(DiaryFindBundle.Request requestBundle) {
        Diary diary = diaryRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.DIARY_DOES_NOT_EXIST.name()));
        return diaryConverter.toDiaryFindBundleResponse(diary);
    }

    @Transactional(readOnly = true)
    public DiaryGetCountBundle.Response getCount() {
        Long totalCount = diaryRepository.getCount();
        return DiaryGetCountBundle.Response.of(totalCount);
    }

    @Transactional
    public DiaryUpdateBundle.Response update(DiaryUpdateBundle.Request requestBundle) {
        Diary diary = diaryRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.DIARY_DOES_NOT_EXIST.name()))
                .update(requestBundle.getTitle(), requestBundle.getContent());
        return diaryConverter.toDiaryUpdateBundleResponse(diary);
    }

    @Transactional
    public DiaryUpdateStatusBundle.Response updateStatus(DiaryUpdateStatusBundle.Request requestBundle) {
        Diary diary = diaryRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.DIARY_DOES_NOT_EXIST.name()))
                .updateStatus();
        return diaryConverter.toDiaryUpdateStatusBundleResponse(diary);
    }

    @Transactional
    public DiaryDeleteBundle.Response delete(DiaryDeleteBundle.Request requestBundle) {
        Diary diary = diaryRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.DIARY_DOES_NOT_EXIST.name()))
                .delete();
        return diaryConverter.toDiaryDeleteBundleResponse(diary);
    }
}
