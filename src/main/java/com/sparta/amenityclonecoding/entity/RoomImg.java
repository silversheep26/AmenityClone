package com.sparta.amenityclonecoding.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name="TB_ROOMIMG")
@NoArgsConstructor
public class RoomImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomImgId;

    @Column(nullable = false)
    private String roomUrl;

    @Column(nullable = false)
    private Long imgCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    public RoomImg(String roomUrl, Room room, Long imgCnt) {
        this.roomUrl = roomUrl;
        this.room = room;
        this.imgCnt = imgCnt;
    }
}
