package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name="TB_RESERVE")
@NoArgsConstructor
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
//
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String payMethod;
    @Column(nullable = false)
    private Long amenityId;
    @Column(nullable = false)
    private Long roomId;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private String reserveStartDate;
    @Column(nullable = false)
    private String reserveEndDate;
    @Column(nullable = false)
    private String createDate;
}
