CREATE TABLE IF NOT EXISTS member
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS coupon
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255)                                     NOT NULL COMMENT '이름',
    status     ENUM ('CREATED', 'PUBLISHED', 'USED', 'EXPIRED') NOT NULL COMMENT '상태',
    started_at DATETIME                                         NOT NULL COMMENT '시작일',
    expired_at DATETIME                                         NOT NULL COMMENT '만료일',
    member_id  BIGINT                                           NOT NULL,
    CONSTRAINT fk_coupon_member FOREIGN KEY (member_id) REFERENCES member (id)
);
