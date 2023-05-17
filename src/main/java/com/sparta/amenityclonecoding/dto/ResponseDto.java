package com.sparta.amenityclonecoding.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 성공만 담기
@Getter
@AllArgsConstructor
public class ResponseDto {
    private String msg;
    private HttpStatus code;
}
