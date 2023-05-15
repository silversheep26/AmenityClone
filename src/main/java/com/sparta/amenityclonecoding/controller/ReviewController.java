package com.sparta.amenityclonecoding.controller;

import com.sparta.amenityclonecoding.dto.ResponseDto;
import com.sparta.amenityclonecoding.dto.ReviewDto;
import com.sparta.amenityclonecoding.security.UserDetailsImpl;
import com.sparta.amenityclonecoding.service.ReviewService;
import com.sparta.amenityclonecoding.service.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final S3Service s3Service;



    @Operation(summary = "숙박업소 상세 조회 내  로그인 유저만 리뷰 작성 API" , description = "숙박업소 리뷰 작성")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "숙박업소 리뷰 작성")})
    @PostMapping("/api/detail/{amenityId}/review")
    public ResponseDto writeReview(@PathVariable Long amenityId, @RequestBody ReviewDto reviewDto, @RequestPart("imgUrl") List<MultipartFile> image,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails) throws Exception {
        return reviewService.writeReview(amenityId, reviewDto, image, userDetails.getUser());
//        return reviewService.writeReview(amenityId, image, userDetails.getUser());
    }
}
