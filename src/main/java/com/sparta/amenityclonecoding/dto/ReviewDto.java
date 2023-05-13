package com.sparta.amenityclonecoding.dto;


import com.sparta.amenityclonecoding.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    private double reviewStar;
    private double reviewScore;
    private String reviewContents;
    private List<ReviewImgDto> reviewImgList = new ArrayList<>();

    public ReviewDto(Review review) {
        this.reviewStar = review.getReviewStar();
        this.reviewScore = review.getReviewScore();
        this.reviewContents = review.getReviewContents();
    }
}
