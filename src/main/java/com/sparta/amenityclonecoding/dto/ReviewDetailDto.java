package com.sparta.amenityclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDetailDto {

    private double reviewStar;
    private double reviewScore;
    private List<ReviewDto> reviewDtoList = new ArrayList<>();

    public ReviewDetailDto(double reviewStar, double reviewScore, List<ReviewDto> reviewDtoList) {
        this.reviewStar = reviewStar;
        this.reviewScore = reviewScore;
        this.reviewDtoList = reviewDtoList;
    }
}
