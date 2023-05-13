package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.Review;
import com.sparta.amenityclonecoding.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewByAmenity_AmenityId(Long amenityId);
}
