package com.rdr.diary.presentation;

import com.rdr.common.dto.BaseResponse;
import com.rdr.common.dto.ResponseMessage;
import com.rdr.diary.application.DiaryService;
import com.rdr.diary.converter.DiaryConverter;
import com.rdr.diary.dto.*;
import com.rdr.diary.dto.bundle.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Api("Diary")
@RequestMapping("api/v1/diaries")
@RestController
public class DiaryController {
    private final DiaryService diaryService;

    @ApiOperation("Diary 생성")
    @PostMapping
    public ResponseEntity<BaseResponse<DiaryCreateDto.Response>> create(@Valid @RequestBody DiaryCreateDto.Request request) {
        DiaryCreateBundle.Request bundleRequest = DiaryConverter.toDiaryCreateBundleRequest(request);
        DiaryCreateBundle.Response bundleResponse = diaryService.create(bundleRequest);

        DiaryCreateDto.Response response = DiaryConverter.toDiaryCreateDtoResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.DIARY_CREATE_SUCCESS, response);
    }

    @ApiOperation("Diary 전체 찾기")
    @GetMapping
    public ResponseEntity<BaseResponse<DiaryFindAllDto.Response>> find() {
        DiaryGetCountBundle.Response countBundleResponse = diaryService.getCount();
        DiaryFindAllBundle.Response diariesBundleResponse = diaryService.find();

        DiaryFindAllDto.Response response = DiaryConverter.toDiaryFindAllDtoResponse(countBundleResponse, diariesBundleResponse);
        return BaseResponse.of(ResponseMessage.DIARIES_FIND_SUCCESS, response);
    }

    @ApiOperation("Diary 하나 찾기")
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<DiaryFindDto.Response>> find(@PathVariable Long id) {
        DiaryFindBundle.Request bundleRequest = DiaryFindBundle.Request.of(id);
        DiaryFindBundle.Response bundleResponse = diaryService.find(bundleRequest);

        DiaryFindDto.Response response = DiaryConverter.toDiaryFindDtoResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.DIARY_FIND_SUCCESS, response);
    }

    @ApiOperation("Diary 수정")
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<DiaryUpdateDto.Response>> update(@PathVariable Long id, @RequestBody DiaryUpdateDto.Request request) {
        DiaryUpdateBundle.Request bundleRequest = DiaryConverter.toDiaryUpdateBundleRequest(id, request);
        DiaryUpdateBundle.Response bundleResponse = diaryService.update(bundleRequest);

        DiaryUpdateDto.Response response = DiaryConverter.toDiaryUpdateDtoResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.DIARY_UPDATE_SUCCESS, response);
    }

    @ApiOperation("Diary 상태 변경")
    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse<DiaryUpdateStatusDto.Response>> updateStatus(@PathVariable Long id) {
        DiaryUpdateStatusBundle.Request bundleRequest = DiaryUpdateStatusBundle.Request.of(id);
        DiaryUpdateStatusBundle.Response bundleResponse = diaryService.updateStatus(bundleRequest);

        DiaryUpdateStatusDto.Response response = DiaryConverter.toDiaryUpdateStatusDtoResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.DIARY_UPDATE_STATUS_SUCCESS, response);
    }

    @ApiOperation("Diary 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<DiaryDeleteDto.Response>> delete(@PathVariable Long id) {
        DiaryDeleteBundle.Request bundleRequest = DiaryDeleteBundle.Request.of(id);
        DiaryDeleteBundle.Response bundleResponse = diaryService.delete(bundleRequest);

        DiaryDeleteDto.Response response = DiaryConverter.toDiaryDeleteDtoResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.DIARY_DELETE_SUCCESS, response);
    }
}
