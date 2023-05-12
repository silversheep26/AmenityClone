package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    List<Amenity> findAmenityByAmenityCategory(String amenityCategory);

}
