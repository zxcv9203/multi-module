package org.example.core.common.response;

public record ApiResponse<T>(
        String code,
        String message,
        T data
) {
    public static <T> ApiResponse<T> of(ResponseCode code, T data) {
        return new ApiResponse<>(code.getCode(), code.getMessage(), data);
    }
}
