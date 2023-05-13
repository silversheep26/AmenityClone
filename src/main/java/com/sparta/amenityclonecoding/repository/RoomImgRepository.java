package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.RoomImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomImgRepository extends JpaRepository<RoomImg, Long> {
}
