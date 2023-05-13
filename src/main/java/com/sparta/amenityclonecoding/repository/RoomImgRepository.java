package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.AmenityImg;
import com.sparta.amenityclonecoding.entity.RoomImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomImgRepository extends JpaRepository<RoomImg, Long> {
    List<RoomImg> findRoomImgByRoom_RoomId(Long amenityId);
}
