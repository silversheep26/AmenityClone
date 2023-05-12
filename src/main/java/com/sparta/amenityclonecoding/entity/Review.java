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

    @Column(nullable = false, unique = true)
    private int reviewStar;

    // amenity join
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenityId", nullable = false)
    private Amenity amenity;

    // reviewImg join
    @OneToMany(mappedBy = "review",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ReviewImg> reviewImgList = new ArrayList<>();
}
