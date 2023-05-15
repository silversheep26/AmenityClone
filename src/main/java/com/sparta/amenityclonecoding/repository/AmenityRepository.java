package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.Amenity;
import com.sparta.amenityclonecoding.repository.Amenity.AmenitySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long>, AmenitySearch {
    Amenity findAmenityByAmenityId(Long amenityId);
    List<Amenity> findAmenityByAmenityCategory(String amenityCategory);
    List<Amenity> findAmenityByAmenityTypeAndAmenityLocationAndAmenityDetailLocation(Long amenityType, String Location, String LocationDetail );
}
