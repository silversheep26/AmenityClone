package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity(name="TB_RESERVE")
@NoArgsConstructor
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserveId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private int userId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenityId", nullable = false)
    private int amenityId;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME_FIELD")
    private Date createdate;
}
