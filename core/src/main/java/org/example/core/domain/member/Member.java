package org.example.core.domain.member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Member {
    private Long id;
    private String name;
}
