package com.example.shipgofunding.config.errors.exception;

import com.example.shipgofunding.config.utils.ApiResponseBuilder;
import lombok.Getter;

@Getter
public class Exception500 extends RuntimeException {
    public Exception500(String message) {
        super(message);
    }

    public ApiResponseBuilder.ApiResponse<?> body() {
        return ApiResponseBuilder.error(getMessage());
    }
}
