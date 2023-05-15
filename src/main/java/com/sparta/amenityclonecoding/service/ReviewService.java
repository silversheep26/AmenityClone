package com.sparta.amenityclonecoding.service;

import com.sparta.amenityclonecoding.dto.ResponseDto;
import com.sparta.amenityclonecoding.dto.ReviewDto;
import com.sparta.amenityclonecoding.entity.Review;
import com.sparta.amenityclonecoding.entity.ReviewImg;
import com.sparta.amenityclonecoding.entity.User;
import com.sparta.amenityclonecoding.repository.ReviewImgRepository;
import com.sparta.amenityclonecoding.repository.ReviewRepository;
import com.sparta.amenityclonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewImgRepository reviewImgRepository;
    private final S3Service s3Service;

    // 리뷰 작성
    @Transactional
    public ResponseDto writeReview(Long amenityId, ReviewDto reviewDto, List<MultipartFile> image, User user) throws IOException {
        User member = userRepository.findUserByUserEmail(user.getUserEmail()).orElseThrow(
                () -> new IllegalArgumentException("로그인 후 이용 가능합니다.")
        );
        List<String> imgPaths = s3Service.uploadImage(image);
        String reviewTitle = reviewDto.getReviewTitle();
        double reviewStar = reviewDto.getReviewStar();
        double reviewScore = reviewDto.getReviewScore();
        String reviewContents = reviewDto.getReviewContents();
        Review review = new Review(reviewTitle, reviewStar, reviewScore, reviewContents, user);
        reviewRepository.save(review);
        makeReviewImg(review, imgPaths);

        return new ResponseDto("리뷰 작성 성공", HttpStatus.OK);
    }

    @Transactional
    public void makeReviewImg(Review review, List<String> imgUrl) {
        for(String url: imgUrl) {
            ReviewImg reviewImg = new ReviewImg(url, review);
            reviewImgRepository.save(reviewImg);
        }
    }
}


// review image 를 먼저 저장 후 review Id 와 연결
// 리뷰 저장 (id) -> 리뷰 id 값을 매개변수로 넘겨준다 리뷰 id 와 리뷰 이미지를 같이 저장