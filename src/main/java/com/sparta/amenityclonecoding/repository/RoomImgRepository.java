package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.AmenityImg;
import com.sparta.amenityclonecoding.entity.RoomImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomImgRepository extends JpaRepository<RoomImg, Long> {
    List<RoomImg> findRoomImgByRoom_RoomId(Long amenityId);
    @Query("select count(r) from TB_ROOMIMG r where r.room.roomId = :roomId")
    Long findImg_AmenityId(@Param("roomId") Long roomId);
}
