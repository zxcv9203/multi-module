package org.example.core.infrastructure.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.core.domain.coupon.CouponStatus;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class CouponJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Comment("이름")
    private String name;

    @Column(name = "상태")
    @Enumerated(EnumType.STRING)
    @Comment("상태")
    private CouponStatus status;

    @Column(name = "started_at")
    @Comment("시작일")
    private LocalDateTime startedAt;

    @Column(name = "expired_at")
    @Comment("만료일")
    private LocalDateTime expiredAt;
}
