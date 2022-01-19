package com.rdr.diary.converter;

import com.rdr.diary.domain.Diary;
import com.rdr.diary.dto.*;
import com.rdr.diary.dto.bundle.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryConverter {
    /**
     * toEntity
     */
    public static Diary toDiary(DiaryCreateBundle.Request bundleRequest) {
        return Diary.builder()
                .author(bundleRequest.getAuthor())
                .title(bundleRequest.getTitle())
                .content(bundleRequest.getContent())
                .build();
    }

    /**
     * toBundleRequest
     */
    public static DiaryCreateBundle.Request toDiaryCreateBundleRequest(DiaryCreateDto.Request request) {
        return DiaryCreateBundle.Request
                .builder()
                .author(request.getAuthor())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public static DiaryUpdateBundle.Request toDiaryUpdateBundleRequest(Long id, DiaryUpdateDto.Request request) {
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
    public static DiaryCreateBundle.Response toDiaryCreateBundleResponse(Diary diary) {
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

    public static DiaryFindAllBundle.Response toDiaryFindAllBundleResponse(List<Diary> diaries) {
        List<DiaryFindBundle.Response> diaryFindBundleResponses = diaries.stream()
                .map(DiaryConverter::toDiaryFindBundleResponse)
                .collect(Collectors.toList());
        return DiaryFindAllBundle.Response.of(diaryFindBundleResponses);
    }

    public static DiaryFindBundle.Response toDiaryFindBundleResponse(Diary diary) {
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

    public static DiaryUpdateBundle.Response toDiaryUpdateBundleResponse(Diary diary) {
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

    public static DiaryDeleteBundle.Response toDiaryDeleteBundleResponse(Diary diary) {
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

    public static DiaryUpdateStatusBundle.Response toDiaryUpdateStatusBundleResponse(Diary diary) {
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
    public static DiaryCreateDto.Response toDiaryCreateDtoResponse(DiaryCreateBundle.Response bundleResponse) {
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

    public static DiaryFindAllDto.Response toDiaryFindAllDtoResponse(DiaryGetCountBundle.Response countBundleResponse, DiaryFindAllBundle.Response diariesBundleResponse) {
        List<DiaryFindDto.Response> diaryFindDtoResponses = diariesBundleResponse.getDiaryFindBundleResponses()
                .stream()
                .map(DiaryConverter::toDiaryFindDtoResponse)
                .collect(Collectors.toList());

        return DiaryFindAllDto.Response
                .builder()
                .totalCount(countBundleResponse.getTotalCount())
                .diaries(diaryFindDtoResponses)
                .build();
    }

    public static DiaryFindDto.Response toDiaryFindDtoResponse(DiaryFindBundle.Response bundleResponse) {
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

    public static DiaryUpdateDto.Response toDiaryUpdateDtoResponse(DiaryUpdateBundle.Response bundleResponse) {
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

    public static DiaryUpdateStatusDto.Response toDiaryUpdateStatusDtoResponse(DiaryUpdateStatusBundle.Response bundleResponse) {
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

    public static DiaryDeleteDto.Response toDiaryDeleteDtoResponse(DiaryDeleteBundle.Response bundleResponse) {
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
