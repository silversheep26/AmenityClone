package com.sparta.amenityclonecoding.dto;

import com.sparta.amenityclonecoding.entity.ReviewImg;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewImgDto {
    private String reviewingImgUrl;

    public ReviewImgDto(ReviewImg reviewImg) {
        this.reviewingImgUrl = reviewImg.getReviewingImgUrl();
    }
}
