package com.sparta.amenityclonecoding.dto;

import com.sparta.amenityclonecoding.entity.Amenity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AmenityDto {
    private String amenityLocation;
    private String amenityDetailLocation;
    private String amenityCategory;
    private String amenityCommon;
    private String amenityIn;
    private Long amenityLikeCnt;
    private String amenityPeople;
    private String amenityEtc;

    public AmenityDto(Amenity amenity) {
        this.amenityLocation = amenity.getAmenityLocation();
        this.amenityDetailLocation = amenity.getAmenityDetailLocation();
        this.amenityCategory = amenity.getAmenityCategory();
        this.amenityCommon = amenity.getAmenityCommon();
        this.amenityIn = amenity.getAmenityIn();
        this.amenityLikeCnt = amenity.getAmenityLikeCnt();
        this.amenityPeople = amenity.getAmenityPeople();
        this.amenityEtc = amenity.getAmenityEtc();
    }




}
