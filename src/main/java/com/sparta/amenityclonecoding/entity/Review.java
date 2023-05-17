package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity(name="TB_REVIEW")
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private String reviewTitle;

    @Column(nullable = false)
    private double reviewStar;

    @Column(nullable = false)
    private double reviewScore;

    @Column(nullable = false)
    private String reviewContents;

//    user 에 있는 email 쓸 예정
//    @Column(nullable = false)
//    private String reviewEmail;

    // user join
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // amenity join
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenityId", nullable = false)
    private Amenity amenity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id", nullable = false)
    private Reserve reserve;

    // reviewImg join
    @OneToMany(mappedBy = "review",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ReviewImg> reviewImgList = new ArrayList<>();

    public Review(String reviewTitle, double reviewStar, double reviewScore, String reviewContents, User user, Amenity amenity, Reserve reserve) {
        this.reviewTitle = reviewTitle;
        this.reviewStar = reviewStar;
        this.reviewScore = reviewScore;
        this.reviewContents = reviewContents;
        this.user = user;
        this.amenity = amenity;
        this.reserve = reserve;
    }
}
