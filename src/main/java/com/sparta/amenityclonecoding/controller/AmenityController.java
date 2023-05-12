package com.sparta.amenityclonecoding.controller;

import com.sparta.amenityclonecoding.dto.AmenityDetailResponseDto;
import com.sparta.amenityclonecoding.dto.AmenityDto;
import com.sparta.amenityclonecoding.dto.AmenityRequestDto;
import com.sparta.amenityclonecoding.dto.AmenityResponseDto;
import com.sparta.amenityclonecoding.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Tag(name = "AmenityController", description = "숙박업소 정보 Controller")
@RequestMapping("/api/amenity")
public class AmenityController {

    private final AmenityService amenityService;

    // 하나 눌렀을 때
    @GetMapping("/detail/{amenityId}")
    public AmenityResponseDto getAmenityDetail(@PathVariable Long amenityId) {
        return amenityService.getAmenityDetail();
    }

    // 호텔과 펜션 목록 조회
    @Operation(summary = "호텔 전체 목록 보기 API" , description = "맨처음 호텔 클릭했을 때")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "맨처음 호텔 클릭했을 때")})
    @GetMapping("/{amenityCategory}")
    public List<AmenityDto> getHotelInfo(@PathVariable String amenityCategory) {
        return amenityService.getHotelInfo(amenityCategory);
    }

    // 호텔에서 적용 눌렀을 때
    // requestbody 에 적용받을 필터를 받는다.
    @Operation(summary = "호텔 선택 목록 보기 API" , description = "호텔에서 조건 선택하고 클릭했을 때")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "호텔에서 조건 선택하고 클릭했을 때")})
    @PostMapping("/hotel/filterAmenity")
    public List<AmenityDto> getHotelDetailInfo(@RequestBody AmenityRequestDto reqeustDto) {
        return amenityService.getPensionDetailInfo(reqeustDto);
    }

    // 펜션에서 적용 눌렀을 때 (가격 드래그)
    // requestbody 에 적용받을 필터를 받는다
    @Operation(summary = "펜션 선택 목록 보기 API" , description = "펜션에서 조건 선택하고 클릭했을 때")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "펜션에서 조건 선택하고 클릭했을 때")})
    @PostMapping("/pension/filterAmenity")
    public List<AmenityDto> getPensionDetailInfo(@RequestBody AmenityRequestDto reqeustDto) {
        return amenityService.getPensionDetailInfo(reqeustDto);
    }

}
