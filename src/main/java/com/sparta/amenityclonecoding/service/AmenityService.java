package com.sparta.amenityclonecoding.service;

import com.sparta.amenityclonecoding.dto.*;
import com.sparta.amenityclonecoding.entity.*;
import com.sparta.amenityclonecoding.repository.*;
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
    private final RoomRepository roomRepository;
    private final RoomImgRepository roomImgRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewImgRepository reviewImgRepository;


    // 하나 눌렀을 때
    @Transactional(readOnly = true)
    public AmenityDetailDto getAmenityDetail(Long amenityId) {
        Amenity amenity = amenityRepository.findAmenityByAmenityId(amenityId);
        AmenityDetailDto amenityDetailDto = new AmenityDetailDto(amenity);

        //숙박업소 정보 img url mapping 준비
        List<AmenityImg> amenityImgList = amenityImgRepository.findAmenityImgByAmenity_AmenityId(amenityId);
        List<AmenityImgDto> amenityImgDtoList = null;

        //숙박업소 img url 리스트 매핑
        for(AmenityImg amenityImg: amenityImgList) {
            AmenityImgDto amenityImgDto = new AmenityImgDto(amenityImg);
            amenityImgDtoList.add(amenityImgDto);
        }
        amenityDetailDto.setAmenityImgDtoList(amenityImgDtoList);

        //객실정보 + 객실정보 img url mapping 준비
        List<Room> roomList = roomRepository.findRoomByAmenity_AmenityId(amenityId);
        List<RoomImgDto> roomImgDtoList = null;
        List<RoomDto> roomDtoList = null;
        //객실정보당 img url 값 mapping
        for(Room room: roomList) {
            RoomDto roomDto = new RoomDto(room);
            List<RoomImg> roomImgList = roomImgRepository.findRoomImgByRoom_RoomId(room.getRoomId());
            for(RoomImg roomImg: roomImgList) {
                RoomImgDto roomImgDto = new RoomImgDto(roomImg);
                roomImgDtoList.add(roomImgDto);
            }
            roomDto.setRoomImgDtoList(roomImgDtoList);
            roomDtoList.add(roomDto);
        }

        //리뷰정보 + 리뷰정보 img url mapping 준비
        List<Review> reviewList = reviewRepository.findReviewByAmenity_AmenityId(amenityId);
        List<ReviewImgDto> reviewImgDtoList = null;
        List<ReviewDto> reviewDtoList = null;
        for (Review review: reviewList) {
            ReviewDto reviewDto = new ReviewDto(review);
            List<ReviewImg> reviewImgList = reviewImgRepository.findReviewImgByReview_ReviewId(review.getReviewId());
            //리뷰정보당 img url 값 mapping
            for(ReviewImg reviewImg: reviewImgList) {
                ReviewImgDto reviewImgDto = new ReviewImgDto(reviewImg);
                reviewImgDtoList.add(reviewImgDto);
            }
            reviewDto.setReviewImgList(reviewImgDtoList);
            reviewDtoList.add(reviewDto);
        }

        //숙박업소 정보(+사진) + 객실 정보(+사진) + 리뷰(+사진)
        amenityDetailDto.setRoomDtoList(roomDtoList);
        amenityDetailDto.setReviewDtoList(reviewDtoList);

        return amenityDetailDto;
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

