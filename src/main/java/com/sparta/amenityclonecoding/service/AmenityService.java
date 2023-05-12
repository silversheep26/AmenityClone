package com.sparta.amenityclonecoding.service;

import com.sparta.amenityclonecoding.dto.AmenityDetailResponseDto;
import com.sparta.amenityclonecoding.dto.AmenityDto;
import com.sparta.amenityclonecoding.entity.Amenity;
import com.sparta.amenityclonecoding.repository.AmenityRepository;
import com.sparta.amenityclonecoding.repository.HotelRepository;
import com.sparta.amenityclonecoding.repository.PensionRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;



    public AmenityDetailResponseDto getAmenityDetail() {

    }

// 호텔과 펜션 목록 조회
    @Transactional(readOnly = true)
    public List<AmenityDto> getHotelInfo(String amenityCategory) {
        List<Amenity> hotelAmenity = amenityRepository.findAmenityByAmenityCategory(amenityCategory);
        List<AmenityDto> amenityDtoList = new ArrayList<>();
        for (Amenity amenity : hotelAmenity) {
            amenityDtoList.add(new AmenityDto(amenity));
        }
        return amenityDtoList;
    }

//    @Transactional(readOnly = true)
//    public List<Amenity> getHotelDetailInfo() {
//        List<Amenity> hotelAmenity = amenityRepository.findAmenityByAmenityCategory()
//    }


    // 호텔에서 적용 눌렀을 때
    @Transactional(readOnly = true)
    public List<AmenityDto> getPensionInfo() {

        List<Amenity> pensionList  = amenityRepository.findAmenityByAmenityCategory();
        List<AmenityDto> pesiontListDtoList = new ArrayList<>();

        for (Amenity amenity:pesionList) {
            pesiontListDtoList.add(new AmenityDto(amenity));
        }
        return pesiontListDtoList;
    }

    // 펜션에서 적용 눌렀을 때(가격 드래그)
    @Transactional(readOnly = true)
    public List<AmenityDto> getPensionDetailInfo() {

        List<Amenity> pensionList  = amenityRepository.findAmenityByAmenityCategory(pension);
        List<AmenityDto> pesiontListDtoList = new ArrayList<>();

        for (Amenity amenity:pesionList) {
            pesiontListDtoList.add(new AmenityDto(amenity));
        }
        return pesiontListDtoList;
    }
}

