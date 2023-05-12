package com.sparta.amenityclonecoding.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@Entity(name="TB_AMENITYIMG")
@NoArgsConstructor
public class AmenityImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityImgId;

    @Column(nullable = false)
    private String imageUrl;

    // amenity join
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenityId", nullable = false)
    private Amenity amenity;

}
