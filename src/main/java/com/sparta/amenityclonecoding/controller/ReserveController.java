package com.sparta.amenityclonecoding.controller;

import com.sparta.amenityclonecoding.dto.AmenityDto;
import com.sparta.amenityclonecoding.dto.AmenityRequestDto;
import com.sparta.amenityclonecoding.dto.ReserveRequestDto;
import com.sparta.amenityclonecoding.dto.ReserveResponseDto;
import com.sparta.amenityclonecoding.service.AmenityService;
import com.sparta.amenityclonecoding.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "ReserveController", description = "숙박업소 등록/조회 정보 Controller")
@RequestMapping("/api/reserve")
public class ReserveController {
    private final ReserveService reserveService;
//    @Operation(summary = "호텔/펜션 전체 목록 보기 API" , description = "맨처음 호텔/펜션 클릭했을 때")
//    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "맨처음 호텔/펜션 클릭했을 때")})
//    @GetMapping("get/{amenityType}")
//    public List<AmenityDto> getAmenityInfo(@PathVariable Long amenityType) {
//        return reserveService.getAmenityInfo(amenityType);
//    }


    @Operation(summary = "호텔/펜션 예약 조회 API" , description = "호텔/펜션에서 예약 조회 했을 때 ")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "호텔/펜션에서 예약내역 클릭했을 때")})
    @PostMapping("/register/{userId}")
    public List<ReserveResponseDto> getReserveInfo(@PathVariable String userId,@RequestBody ReserveRequestDto reserveRequestDto) {
        return reserveService.getReserveInfo(reserveRequestDto);
    }

}
