package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Getter
@Entity(name="TB_AMENITY")
@NoArgsConstructor
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;

    @Column(nullable = false)
    private String amenityLocation;

    @Column(nullable = false)
    private String amenityDetailLocation;

    @Column(nullable = false)
    private String amenityCategory;

    @Column(nullable = false)
    private String amenityCommon;

    @Column(nullable = false)
    private String amenityIn;

    @Column(nullable = false)
    private Long amenityLikeCnt;

    @Column(nullable = false)
    private String amenityPeople;

    @Column(nullable = false)
    private String amenityEtc;

    @Column(nullable = false)
    private Long amenityType;
    /*BED TYPE*/
    @Column(nullable = false)
    private String amenityVal;

    @Column(nullable = false)
    private String amenityAddr; // 숙박업소 주소
    @Column(nullable = false)
    private String amenityAddr2; // 시 또는 구

    @Column(nullable = false)
    private String amenityNm;

    @OneToMany(mappedBy = "amenity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<AmenityImg> amenityImgList = new ArrayList<>();

    //room은 객실 상세 정보를 의미함
    @OneToMany(mappedBy = "amenity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Room> roomList = new ArrayList<>();

    @OneToMany(mappedBy = "amenity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Review> reviewList = new ArrayList<>();

    public Amenity(String amenityLocation, String amenityDetailLocation, String amenityCategory, String amenityCommon, String amenityIn, Long amenityLikeCnt) {
        this.amenityLocation = amenityLocation;
        this.amenityDetailLocation = amenityDetailLocation;
        this.amenityCategory = amenityCategory;
        this.amenityCommon = amenityCommon;
        this.amenityIn = amenityIn;
        this.amenityLikeCnt = amenityLikeCnt;
    }
}
