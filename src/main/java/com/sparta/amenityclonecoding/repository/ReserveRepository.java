package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.RefreshToken;
import com.sparta.amenityclonecoding.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findByUserId(Long userId);

    List<Reserve> findReserveByAmenityIdAndUserEmailOrderByCreateDateDesc(Long amenityId, String userEmail);

}
