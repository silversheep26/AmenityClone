package com.sparta.amenityclonecoding.dto;

import com.sparta.amenityclonecoding.entity.AmenityImg;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AmenityImgDto {
    private String imageUrl;

    private Long imgCnt;

    public AmenityImgDto(AmenityImg amenityImg) {
        this.imageUrl = amenityImg.getImageUrl();
        this.imgCnt = amenityImg.getImgCnt();
    }
}
