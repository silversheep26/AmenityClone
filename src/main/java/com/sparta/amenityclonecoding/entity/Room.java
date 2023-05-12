package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name="TB_ROOM")
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false)
    private String roomNm;

    @Column(nullable = false)
    private String roomPrice;

    @Column(nullable = false)
    private String roomUrl;

    @Column(nullable = false)
    private String roomChk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenityId", nullable = false)
    private Amenity amenity;

    // 방하나에 사진 여러개 join
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<RoomImg> roomImgList = new ArrayList<>();

    public Room(String roomNm, String roomPrice, String roomUrl, String roomChk, Amenity amenity) {
        this.roomNm = roomNm;
        this.roomPrice = roomPrice;
        this.roomUrl = roomUrl;
        this.roomChk = roomChk;
        this.amenity = amenity;
    }
}
