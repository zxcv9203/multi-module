package org.example.core.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("0", "성공"),
    UNKNOWN_ERROR("-1", "알 수 없는 오류");

    private final String code;
    private final String message;
}
