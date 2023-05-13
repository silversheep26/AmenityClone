package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.AmenityImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityImgRepository extends JpaRepository<AmenityImg, Long> {
    List<AmenityImg> findAmenityImgByAmenity_AmenityId(Long amenityId);

}


