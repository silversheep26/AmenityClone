package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "TB_reviewImg")
@NoArgsConstructor
public class ReviewImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewImgId;

    @Column(nullable = false, unique = true)
    private String reviewingImgUrl;

    // review 하나에 reviewImage 여러개
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewId", nullable = false)
    private Review review;

    public ReviewImg(String reviewingImgUrl) {
        this.reviewingImgUrl = reviewingImgUrl;
    }
}
