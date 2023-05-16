package com.sparta.amenityclonecoding.controller;

import com.sparta.amenityclonecoding.dto.*;
import com.sparta.amenityclonecoding.entity.Reserve;
import com.sparta.amenityclonecoding.security.UserDetailsImpl;
import com.sparta.amenityclonecoding.service.AmenityService;
import com.sparta.amenityclonecoding.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "ReserveController", description = "숙박업소 등록/조회 정보 Controller")
@RequestMapping("/api/reserve")
public class ReserveController {
    private final ReserveService reserveService;

    // 예약 조회
    @ResponseBody
    @GetMapping("/myreservelist")
    public List<ReserveResponseDto> getAmenityInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reserveService.getReserveInfo(userDetails.getUser());
    }

    // 예약 등록
    @Operation(summary = "호텔/펜션 예약 등록 API" , description = "호텔/펜션에서 예약 등록 했을 때 ")
    @ApiResponses(value ={@ApiResponse(responseCode= "200", description = "예약 등록할 때")})
    @PostMapping("/register")
    public ResponseDto setReserveInfo(@RequestBody ReserveRequestDto reserveRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boolean ret = reserveService.setReserveInfo(reserveRequestDto,userDetails.getUser());
        return ret == true ? new ResponseDto("예약 성공", HttpStatus.OK) :new ResponseDto("예약 실패", HttpStatus.NOT_FOUND) ;
    }

    // 예약 삭제
    @ResponseBody
    @DeleteMapping("/myreservelist/delete/{reserveId}")
    public ResponseDto deleteAmenityInfo(@PathVariable Long reserveId,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        boolean ret = reserveService.deleteReserveInfo(reserveId,userDetails.getUser());
        return ret == true ? new ResponseDto("삭제 성공", HttpStatus.OK) :new ResponseDto("삭제 실패", HttpStatus.NOT_FOUND) ;
    }

}
