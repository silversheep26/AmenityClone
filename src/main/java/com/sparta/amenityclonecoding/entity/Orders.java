package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//예약기능 아직 생각좀더해봐야함
@Getter
@Entity(name = "TB_ORDERS")
@NoArgsConstructor
public class Orders extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersId;

    // 예약 시작일
    @Column(nullable = false)
    private int reservationStartDate;

    // 예약 종료일
    @Column(nullable = false)
    private int reservationEndDate;

    // 숙박 일자
    @Column(nullable = false)
    private int reservationMakeDate;

    @Column
    private int ordersCost;

    @Column
    private double ordersDiscount;


//      프로모션
//    @Column
//    private int ordersPromotion;

    // amenity join

    // room join


}
