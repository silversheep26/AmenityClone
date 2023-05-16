package com.sparta.amenityclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ReviewRequestDto {
    private String reviewContent;
    private String reviewTitle;
    private double reviewStar;
    private double reviewScore;

    public ReviewRequestDto(String reviewContent, String reviewTitle, double reviewStar, double reviewScore) {
        this.reviewContent = reviewContent;
        this.reviewTitle = reviewTitle;
        this.reviewStar = reviewStar;
        this.reviewScore = reviewScore;
    }
}
