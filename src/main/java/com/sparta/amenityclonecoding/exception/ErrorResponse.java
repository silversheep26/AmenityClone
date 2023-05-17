package com.sparta.amenityclonecoding.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@Getter
@Builder
public class ErrorResponse {

    private String message;
    private int status;
    private String detail;

    public static ResponseEntity<ErrorResponse> toResponseEntity(ExceptionEnum e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(ErrorResponse.builder()
                        .message(e.getDetailMsg())
                        .status(e.getStatus().value())
                        .build());
    }

    public static ResponseEntity<ErrorResponse> toResponseEntity(HttpStatus httpStatus, String detail) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .message(httpStatus.name())
                        .status(httpStatus.value())
                        .detail(detail)
                        .build());
    }

//    @ExceptionHandler({IllegalArgumentException.class})
//    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
//        e.printStackTrace();
//        return ResponseEntity
//                .status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
//                .body(ApiExceptionEntity.builder()
//                        .errorCode(ExceptionEnum.RUNTIME_EXCEPTION.getCode())
//                        .errorMessage(e.getMessage())
//                        .build());
//    }
//
//    @ExceptionHandler({Exception.class, RuntimeException.class})
//    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception e) {
//        e.printStackTrace();
//        return ResponseEntity
//                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
//                .body(ApiExceptionEntity.builder()
//                        .errorCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
//                        .errorMessage(e.getMessage())
//                        .build());
//    }
}
