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

    @ManyToOne
    @JoinColumn(name = "member_id")
    @Comment("멤버 ID")
    private MemberJpaEntity owner;

    @Column(name = "name")
    @Comment("이름")
    private String name;

    @Column(name = "status")
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
