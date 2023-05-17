package com.sparta.amenityclonecoding.controller;

import com.sparta.amenityclonecoding.dto.ImgRequestDto;
import com.sparta.amenityclonecoding.dto.ResponseDto;
import com.sparta.amenityclonecoding.exception.Message;
import com.sparta.amenityclonecoding.service.ImgService;
import com.sparta.amenityclonecoding.service.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "ImgController", description = "이미지 업로드 Controller")
@RequestMapping("/imgUpload")
public class ImgController {
    private final ImgService imgService;

    @Operation(summary = "맵핑키값 받아서 데이터 생성 API" , description = "이미지 업로드")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "이미지 업로드")})
    @PostMapping("/{mapId}")
    public ResponseEntity<Message> uploadImg(@PathVariable Long mapId, @RequestPart("chkId") String chkId, @RequestPart("image") List<MultipartFile> image) throws IOException {
        return imgService.uploadImg(mapId, image, chkId);
    }

}
