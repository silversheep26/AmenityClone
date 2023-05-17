package com.sparta.amenityclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChkRoomResponseDto {

    private String roomNm;
    private String roomChk;
    private Long roomPrice;
    private Long totalPrice;
    private Long day;
    private List<RoomImgDto> roomImgDtoList = new ArrayList<>();

    public ChkRoomResponseDto(String roomNm, String roomChk, Long roomPrice, Long totalPrice, Long day) {
        this.roomNm = roomNm;
        this.roomChk = roomChk;
        this.roomPrice = roomPrice;
        this.totalPrice = totalPrice;
        this.day = day;
    }
}
