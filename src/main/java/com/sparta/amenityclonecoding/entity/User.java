package com.sparta.amenityclonecoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "TB_USER")
@NoArgsConstructor
public class User extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private Long userKakaoId;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
//
//    @OneToMany(mappedBy = "reserve", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    private List<Reserve> reserveList = new ArrayList<>();

    // review join (uer(1) : review(M))
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Review> reviewList = new ArrayList<>();

    public User(String userEmail, String userPassword, UserRole role) {
//        this.userKakaoId = userKakaoId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.role = role;
    }
}
