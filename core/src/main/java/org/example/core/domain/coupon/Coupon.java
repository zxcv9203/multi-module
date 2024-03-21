package org.example.core.domain.coupon;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.core.domain.member.Member;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Coupon {
    private Long id;

    private Member owner;

    private String name;

    private CouponStatus status;

    private LocalDateTime startedAt;

    private LocalDateTime expiredAt;
}
