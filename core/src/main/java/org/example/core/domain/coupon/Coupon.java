package org.example.core.domain.coupon;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Coupon {
    private Long id;

    private String name;

    private CouponStatus status;

    private LocalDateTime startedAt;

    private LocalDateTime expiredAt;
}
