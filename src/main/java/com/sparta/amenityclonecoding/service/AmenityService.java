package com.sparta.amenityclonecoding.service;

import com.sparta.amenityclonecoding.dto.AmenityDetailDto;
import com.sparta.amenityclonecoding.dto.AmenityDto;
import com.sparta.amenityclonecoding.dto.AmenityImgDto;
import com.sparta.amenityclonecoding.dto.AmenityRequestDto;
import com.sparta.amenityclonecoding.entity.Amenity;
import com.sparta.amenityclonecoding.entity.AmenityImg;
import com.sparta.amenityclonecoding.repository.AmenityImgRepository;
import com.sparta.amenityclonecoding.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;
    private final AmenityImgRepository amenityImgRepository;


    // 하나 눌렀을 때
    @Transactional(readOnly = true)
    public AmenityDetailDto getAmenityDetail(Long amenityId) {


        return null;
    }

    // 호텔과 펜션 목록 조회
    @Transactional(readOnly = true)
    public List<AmenityDto> getAmenityInfo(Long amenityType) {
        List<Amenity> amenityList = null;
        List<AmenityImgDto> amenityImgDtoList = null;
        List<AmenityDto> amenityDtoList = new ArrayList<>();

        switch (amenityType.toString()) {
            case "0": //호텔
                amenityList = amenityRepository.findAmenityByAmenityTypeAndAmenityLocationAndAmenityDetailLocation(amenityType, "서울", "0");
                break;
            case "1":  //펜션
                amenityList = amenityRepository.findAmenityByAmenityTypeAndAmenityLocationAndAmenityDetailLocation(amenityType, "경기/인천", "0");
                break;
        }

        for (Amenity amenity : amenityList) {
            AmenityDto amenityDto = new AmenityDto(amenity);

            List<AmenityImg> amenityImgList = amenityImgRepository.findAmenityImgByAmenity_AmenityId(amenity.getAmenityId());
            for(AmenityImg img: amenityImgList) {
                amenityImgDtoList.add(new AmenityImgDto(img));
            }

            amenityDto.setAmenityImgDtoList(amenityImgDtoList);
            amenityDtoList.add(amenityDto);
        }

        return amenityDtoList;
    }

    // 호텔에서 적용 눌렀을 때
    @Transactional(readOnly = true)
    public List<AmenityDto> getAmenityFilter(AmenityRequestDto amenityRequestDto) {
        List<Amenity> amenityList = null;
        List<AmenityImgDto> amenityImgDtoList = null;
        List<AmenityDto> amenityDtoList = new ArrayList<>();
        Long amenityType = amenityRequestDto.getAmenityType();
        String amenityLocation = amenityRequestDto.getAmenityLocation();
        String amenityDetailLocation = amenityRequestDto.getAmenityDetailLocation();
        String amenityCommon = String.join(", ", amenityRequestDto.getAmenityCommon());
        String amenityIn = String.join(", ", amenityRequestDto.getAmenityIn());
        String amenityEtc = String.join(", ", amenityRequestDto.getAmenityEtc());

        amenityList = amenityRepository.searchFilter(amenityType, amenityLocation, amenityDetailLocation,
                amenityRequestDto.getAmenityCategory(), amenityRequestDto.getAmenityPeople(),
                amenityRequestDto.getAmenityVal(), amenityCommon, amenityIn, amenityEtc);

        for(Amenity amenity: amenityList) {
            AmenityDto amenityDto = new AmenityDto(amenity);

            List<AmenityImg> amenityImgList = amenityImgRepository.findAmenityImgByAmenity_AmenityId(amenity.getAmenityId());
            for(AmenityImg img: amenityImgList) {
                amenityImgDtoList.add(new AmenityImgDto(img));
            }

            amenityDto.setAmenityImgDtoList(amenityImgDtoList);
            amenityDtoList.add(amenityDto);
        }
        return amenityDtoList;
    }
}

