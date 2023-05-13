package com.sparta.amenityclonecoding.dto;

import com.sparta.amenityclonecoding.entity.ReviewImg;

public class ReviewImgDto {
    private String reviewingImgUrl;

    public ReviewImgDto(ReviewImg reviewImg) {
        this.reviewingImgUrl = reviewImg.getReviewingImgUrl();
    }
}
