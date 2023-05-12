package com.sparta.amenityclonecoding.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AmenityRequestDto {
    private String amenityLocation;
    private String amenityDetailLocation;
    private String amenityCategory;
    private String[] amenityCommon;
    private String[] amenityIn;
    private String[] amenityEtc;
    private Long amenityLikeCnt;
    private String amenityPeople;

}
