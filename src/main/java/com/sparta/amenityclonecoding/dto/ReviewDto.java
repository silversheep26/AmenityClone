package com.sparta.amenityclonecoding.dto;


import com.sparta.amenityclonecoding.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    private String reviewTitle;
    private double reviewStar;
    private double reviewScore;
    private String reviewContents;
    private String reviewEmail;
    private List<ReviewImgDto> reviewImgList = new ArrayList<>();

    public ReviewDto(Review review) {
        this.reviewTitle = review.getReviewTitle();
        this.reviewStar = review.getReviewStar();
        this.reviewScore = review.getReviewScore();
        this.reviewContents = review.getReviewContents();
        this.reviewEmail = review.getUser().getUserEmail();
    }
}
