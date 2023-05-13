package com.sparta.amenityclonecoding.dto;


import com.sparta.amenityclonecoding.entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoomDto {
    private String roomNm;
    private String roomPrice;
    private String roomChk;
    private List<RoomImgDto> roomImgDtoList = new ArrayList<>();

    public RoomDto(Room room) {
        this.roomNm = room.getRoomNm();
        this.roomPrice = room.getRoomPrice();
        this.roomChk = room.getRoomChk();
    }
}
