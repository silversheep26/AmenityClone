package com.sparta.amenityclonecoding.controller;

import com.sparta.amenityclonecoding.dto.AmenityDto;
import com.sparta.amenityclonecoding.dto.AmenityRequestDto;
import com.sparta.amenityclonecoding.dto.AmenityDetailDto;
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

    @Operation(summary = "숙박업소 상세 조회 API" , description = "숙박업소 이미지를 클릭했을 때")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "숙박업소 이미지를 클릭했을 때")})
    @GetMapping("/detail/{amenityId}")
    public AmenityDetailDto getAmenityDetail(@PathVariable Long amenityId) {
        return amenityService.getAmenityDetail(amenityId);
    }


    @Operation(summary = "호텔/펜션 전체 목록 보기 API" , description = "맨처음 호텔/펜션 클릭했을 때")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "맨처음 호텔/펜션 클릭했을 때")})
    @GetMapping("/{amenityType}")
    public List<AmenityDto> getAmenityInfo(@PathVariable Long amenityType) {
        return amenityService.getAmenityInfo(amenityType);
    }


    @Operation(summary = "호텔/펜션 선택 목록 보기(필터) API" , description = "호텔/펜션에서 조건 선택하고 클릭했을 때")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "호텔/펜션에서 조건 선택하고 클릭했을 때")})
    @PostMapping("/hotel/filterAmenity")
    public List<AmenityDto> getAmenityFilter(@RequestBody AmenityRequestDto reqeustDto) {
        return amenityService.getAmenityFilter(reqeustDto);
    }

    @GetMapping("/search")
    public List<AmenityDto> searchAmenity(@RequestParam("keyword") String keyword) {
        return amenityService.search(keyword);
    }
}
