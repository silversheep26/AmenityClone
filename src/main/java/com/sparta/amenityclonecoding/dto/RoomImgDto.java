package com.sparta.amenityclonecoding.dto;

import com.sparta.amenityclonecoding.entity.RoomImg;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomImgDto {
    private String roomUrl;

    private Long imgCnt;

    public RoomImgDto(RoomImg roomImg) {
        this.roomUrl = roomImg.getRoomUrl();
        this.imgCnt = roomImg.getImgCnt();
    }
}
