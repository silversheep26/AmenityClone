package com.sparta.amenityclonecoding.service;

import com.sparta.amenityclonecoding.dto.ReserveRequestDto;
import com.sparta.amenityclonecoding.dto.ReserveResponseDto;
import com.sparta.amenityclonecoding.dto.ResponseDto;
import com.sparta.amenityclonecoding.dto.UserRequestDto;
import com.sparta.amenityclonecoding.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReserveService {
    private final AmenityRepository amenityRepository;
    private final AmenityImgRepository amenityImgRepository;

    @Transactional
    public  List<ReserveResponseDto> getReserveInfo(ReserveRequestDto reserveRequestDto) {
        List<ReserveResponseDto> reserveResponseDtoList = null;

//        reserveRequestDto.


        return reserveResponseDtoList;
    }


}
