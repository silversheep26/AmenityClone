package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.AmenityImg;
import com.sparta.amenityclonecoding.entity.ReviewImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewImgRepository extends JpaRepository<ReviewImg, Long> {
    List<ReviewImg> findReviewImgByReview_ReviewId(Long amenityId);
    @Query("select count(v) from TB_REVIEWIMG v where v.review.reviewId = :reviewId")
    Long findImg_AmenityId(@Param("reviewId") Long reviewId);
}
