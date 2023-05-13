package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name="TB_review")
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private double reviewStar;

    @Column(nullable = false)
    private double reviewScore;

    @Column(nullable = false)
    private String reviewContents;


    // amenity join
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenityId", nullable = false)
    private Amenity amenity;

    // reviewImg join
    @OneToMany(mappedBy = "review",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ReviewImg> reviewImgList = new ArrayList<>();

    public Review(double reviewStar, double reviewScore, String reviewContents) {
        this.reviewStar = reviewStar;
        this.reviewScore = reviewScore;
        this.reviewContents = reviewContents;
    }
}
