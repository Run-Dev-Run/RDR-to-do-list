package com.rdr.diary.converter;

import com.rdr.diary.bundle.*;
import com.rdr.diary.domain.Diary;
import com.rdr.diary.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiaryConverter {
    private DiaryConverter() {
    }

    /**
     * toEntity
     */
    public Diary toDiary(DiaryCreateBundle.Request bundleRequest) {
        return Diary.builder()
                .author(bundleRequest.getAuthor())
                .title(bundleRequest.getTitle())
                .content(bundleRequest.getContent())
                .build();
    }

    /**
     * toBundleRequest
     */
    public DiaryCreateBundle.Request toDiaryCreateBundleRequest(DiaryCreateDto.Request request) {
        return DiaryCreateBundle.Request
                .builder()
                .author(request.getAuthor())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public DiaryUpdateBundle.Request toDiaryUpdateBundleRequest(Long id, DiaryUpdateDto.Request request) {
        return DiaryUpdateBundle.Request
                .builder()
                .id(id)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    /**
     * toBundleResponse
     */
    public DiaryCreateBundle.Response toDiaryCreateBundleResponse(Diary diary) {
        return DiaryCreateBundle.Response
                .builder()
                .author(diary.getAuthor())
                .status(diary.getStatus())
                .title(diary.getTitle())
                .content(diary.getContent())
                .createDate(diary.getCreatedDate())
                .modifiedDate(diary.getModifiedDate())
                .build();
    }

    public DiaryFindAllBundle.Response toDiaryFindAllBundleResponse(List<Diary> diaries) {
        List<DiaryFindBundle.Response> diaryFindBundleResponses = diaries.stream()
                .map(this::toDiaryFindBundleResponse)
                .collect(Collectors.toList());
        return DiaryFindAllBundle.Response.of(diaryFindBundleResponses);
    }

    public DiaryFindBundle.Response toDiaryFindBundleResponse(Diary diary) {
        return DiaryFindBundle.Response
                .builder()
                .author(diary.getAuthor())
                .status(diary.getStatus())
                .title(diary.getTitle())
                .content(diary.getContent())
                .createDate(diary.getCreatedDate())
                .modifiedDate(diary.getModifiedDate())
                .build();
    }

    public DiaryUpdateBundle.Response toDiaryUpdateBundleResponse(Diary diary) {
        return DiaryUpdateBundle.Response
                .builder()
                .author(diary.getAuthor())
                .status(diary.getStatus())
                .title(diary.getTitle())
                .content(diary.getContent())
                .createDate(diary.getCreatedDate())
                .modifiedDate(diary.getModifiedDate())
                .build();
    }

    public DiaryDeleteBundle.Response toDiaryDeleteBundleResponse(Diary diary) {
        return DiaryDeleteBundle.Response
                .builder()
                .author(diary.getAuthor())
                .status(diary.getStatus())
                .title(diary.getTitle())
                .content(diary.getContent())
                .createDate(diary.getCreatedDate())
                .modifiedDate(diary.getModifiedDate())
                .build();
    }

    public DiaryUpdateStatusBundle.Response toDiaryUpdateStatusBundleResponse(Diary diary) {
        return DiaryUpdateStatusBundle.Response
                .builder()
                .author(diary.getAuthor())
                .status(diary.getStatus())
                .title(diary.getTitle())
                .content(diary.getContent())
                .createDate(diary.getCreatedDate())
                .modifiedDate(diary.getModifiedDate())
                .build();
    }

    /**
     * toResponse
     */
    public DiaryCreateDto.Response toDiaryResponse(DiaryCreateBundle.Response bundleResponse) {
        return DiaryCreateDto.Response
                .builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public DiaryFindAllDto.Response toDiaryResponse(DiaryGetCountBundle.Response countBundleResponse, DiaryFindAllBundle.Response diariesBundleResponse) {
        return DiaryFindAllDto.Response
                .builder()
                .totalCount(countBundleResponse.getTotalCount())
                .diaries(diariesBundleResponse.getDiaryFindBundleResponses())
                .build();
    }

    public DiaryFindDto.Response toDiaryResponse(DiaryFindBundle.Response bundleResponse) {
        return DiaryFindDto.Response
                .builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public DiaryUpdateDto.Response toDiaryResponse(DiaryUpdateBundle.Response bundleResponse) {
        return DiaryUpdateDto.Response
                .builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public DiaryUpdateStatusDto.Response toDiaryResponse(DiaryUpdateStatusBundle.Response bundleResponse) {
        return DiaryUpdateStatusDto.Response
                .builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public DiaryDeleteDto.Response toDiaryResponse(DiaryDeleteBundle.Response bundleResponse) {
        return DiaryDeleteDto.Response
                .builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }
}
