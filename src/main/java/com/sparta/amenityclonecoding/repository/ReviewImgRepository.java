package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.AmenityImg;
import com.sparta.amenityclonecoding.entity.ReviewImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewImgRepository extends JpaRepository<ReviewImg, Long> {
    List<ReviewImg> findReviewImgByReview_ReviewId(Long amenityId);
}
