package com.sparta.amenityclonecoding.repository.Amenity;

import com.sparta.amenityclonecoding.dto.AmenityRequestDto;
import com.sparta.amenityclonecoding.entity.Amenity;

import java.util.List;

public interface AmenitySearch {
//    List<Amenity> searchFilter(Long amenityType, String amenityLocation, String amenityDetailLocation, String amenityCategory,
//                               String amenityPeople, String amenityVal, String amenityCommon, String amenityIn, String amenityEtc);
    List<Amenity> searchFilter(AmenityRequestDto amenityRequestDto);
}
