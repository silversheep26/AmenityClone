package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "TB_REVIEWIMG")
@NoArgsConstructor
public class ReviewImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewImgId;

    @Column(nullable = false)
    private String reviewingImgUrl;

    // review 하나에 reviewImage 여러개
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewId", nullable = false)
    private Review review;

    public ReviewImg(String reviewingImgUrl, Review review) {
        this.reviewingImgUrl = reviewingImgUrl;
        this.review = review;
    }
}
