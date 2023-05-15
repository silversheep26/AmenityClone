package com.sparta.amenityclonecoding.dto;

import com.sparta.amenityclonecoding.entity.Amenity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
// detail info 용
public class AmenityDetailDto {
    private String amenityLocation;
    private String amenityDetailLocation;
    private String amenityCategory;
    private String amenityCommon;
    private String amenityIn;
    private Long amenityLikeCnt;
    private String amenityPeople;
    private String amenityEtc;
    private Long amenityType;
    private String amenityVal;
    private String amenityAddr;
    private String amenityAddr2;
    private String amenityNm;

    private List<AmenityImgDto> amenityImgDtoList = new ArrayList<>();
    private List<RoomDto> roomDtoList = new ArrayList<>();
    private List<ReviewDto> reviewDtoList = new ArrayList<>();

    public AmenityDetailDto(Amenity amenity) {
        this.amenityLocation = amenity.getAmenityLocation();
        this.amenityDetailLocation = amenity.getAmenityDetailLocation();
        this.amenityCategory = amenity.getAmenityCategory();
        this.amenityCommon = amenity.getAmenityCommon();
        this.amenityIn = amenity.getAmenityIn();
        this.amenityLikeCnt = amenity.getAmenityLikeCnt();
        this.amenityPeople = amenity.getAmenityPeople();
        this.amenityEtc = amenity.getAmenityEtc();
        this.amenityType = amenity.getAmenityType();
        this.amenityVal = amenity.getAmenityVal();
        this.amenityAddr = amenity.getAmenityAddr();
        this.amenityAddr2 = amenity.getAmenityAddr2();
    }
}
