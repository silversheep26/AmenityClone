package com.sparta.amenityclonecoding.repository.Amenity;

import com.sparta.amenityclonecoding.dto.AmenityRequestDto;
import com.sparta.amenityclonecoding.entity.Amenity;

import java.util.List;

public interface AmenitySearch {
    List<Amenity> searchFilter(AmenityRequestDto amenityRequestDto);
    List<Amenity> findByKeyword(String keyword);
}
