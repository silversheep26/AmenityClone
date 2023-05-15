package com.sparta.amenityclonecoding.service;

import com.sparta.amenityclonecoding.dto.ReserveRequestDto;
import com.sparta.amenityclonecoding.dto.ReserveResponseDto;
import com.sparta.amenityclonecoding.dto.ResponseDto;
import com.sparta.amenityclonecoding.dto.UserRequestDto;
import com.sparta.amenityclonecoding.entity.*;
import com.sparta.amenityclonecoding.repository.*;
import com.sparta.amenityclonecoding.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReserveService {
    private final ReserveRepository reserveRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final AmenityRepository amenityRepository;
    private final AmenityImgRepository amenityImgRepository;

    @Transactional
    public List<ReserveResponseDto> getReserveInfo(User user) {
        // Retrieve the list of reservations for the given user from the repository
        List<Reserve> reservations = reserveRepository.findByUserId(user.getUserId());

        // Convert the list of reservations to a list of ReserveResponseDto objects
        List<ReserveResponseDto> responseDtoList = new ArrayList<>();
        for (Reserve reservation : reservations) {
            ReserveResponseDto responseDto = new ReserveResponseDto();
            responseDto.setUsername(reservation.getUsername());
            responseDto.setPayMethod(reservation.getPayMethod());
            responseDto.setUserEmail(reservation.getUserEmail());

            // Assuming the room and amenity details are fetched from their respective repositories
            Optional<Room> roomOptional = roomRepository.findById(reservation.getRoomId());
            Optional<Amenity> amenityOptional = amenityRepository.findById(reservation.getAmenityId());
            if (roomOptional.isPresent() && amenityOptional.isPresent()) {
                Room room = roomOptional.get();
                Amenity amenity = amenityOptional.get();
                responseDto.setRoomNm(room.getRoomNm());
                responseDto.setAmenityNm(amenity.getAmenityNm());


                List<AmenityImg> amenityImgList = amenityImgRepository.findAmenityImgByAmenity_AmenityId(amenity.getAmenityId());
                if (!amenityImgList.isEmpty()) {
                    AmenityImg amenityImg = amenityImgList.get(0);
                    responseDto.setAmenityImg(amenityImg.getImageUrl());
                }
            }

            responseDto.setPrice(reservation.getPrice());
            responseDto.setReserveStartDate(reservation.getReserveStartDate());
            responseDto.setReserveEndDate(reservation.getReserveEndDate());

            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }


    @Transactional
    public boolean setReserveInfo(ReserveRequestDto reserveRequestDto, User user) {
        User member = userRepository.findUserByUserEmail(user.getUserEmail()).orElseThrow(
                () -> new IllegalArgumentException("로그인 후 이용 가능합니다.")
        );
        String rxEmail = reserveRequestDto.getUserEmail();
        String userEmail = user.getUserEmail();
        if (rxEmail.equals(userEmail) == false)
            return false;
        Reserve reserve = new Reserve();
        reserve.setUserId(member.getUserId());
        reserve.setAmenityId(reserveRequestDto.getAmenityId());
        reserve.setPrice(reserveRequestDto.getPrice());
        reserve.setReserveStartDate(reserveRequestDto.getReserveStartDate());
        reserve.setReserveEndDate(reserveRequestDto.getReserveEndDate());
        reserve.setRoomId(reserveRequestDto.getRoomoId());
        reserve.setUsername(reserveRequestDto.getUsername());
        reserve.setPayMethod(reserveRequestDto.getPayMethod());
        reserve.setUserEmail(reserveRequestDto.getUserEmail());
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();
        // 현재 날짜 구하기(Paris)
        LocalDate seoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        reserve.setCreateDate(seoulNow.toString());

        reserveRepository.save(reserve);
        return true;
    }

    @Transactional
    public boolean deleteReserveInfo(Long reserveId, User user) {
        User member = userRepository.findUserByUserEmail(user.getUserEmail()).orElseThrow(
                () -> new IllegalArgumentException("로그인 후 이용 가능합니다.")
        );


        // Find the reserve by its ID
        Reserve reserve = reserveRepository.findById(reserveId).orElseThrow(
                () -> new IllegalArgumentException("해당 예약 정보를 찾을 수 없습니다.")
        );

        // Perform the deletion
        reserveRepository.delete(reserve);

        return true;
    }


}
