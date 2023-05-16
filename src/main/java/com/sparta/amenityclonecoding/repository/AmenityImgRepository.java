package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.AmenityImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AmenityImgRepository extends JpaRepository<AmenityImg, Long> {
    List<AmenityImg> findAmenityImgByAmenity_AmenityId(Long amenityId);

    @Query("select count(a) from TB_AMENITYIMG a where a.amenity.amenityId = :amenityId")
    Long findImg_AmenityId(@Param("amenityId") Long amenityId);

}


