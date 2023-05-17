package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.RefreshToken;
import com.sparta.amenityclonecoding.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findByUserId(Long userId);

    List<Reserve> findReserveByAmenityIdAndUserEmailOrderByCreateDateDesc(Long amenityId, String userEmail);

    @Query("select r from TB_RESERVE r where r.reserveStartDate >= :startDat and r.reserveEndDate <= :endDat")
    List<Reserve> chkReserveDat(@Param("startDat") Long startDat, @Param("endDat") Long endDat);

    @Query("select exists (select r from TB_RESERVE r where r.reserveStartDate >= :startDat and r.reserveEndDate <= :endDat and r.amenityId = :amenityId and r.roomId = :roomId ) ")
    boolean chkReserve(@Param("startDat") String StartDat, @Param("endDat") String endDat, @Param("amenityId") Long amenityId, @Param("roomId") Long roomId);

}
