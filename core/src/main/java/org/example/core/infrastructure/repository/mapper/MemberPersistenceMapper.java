package org.example.core.infrastructure.repository.mapper;

import org.example.core.domain.Member;
import org.example.core.infrastructure.repository.model.MemberJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberPersistenceMapper {

    public MemberJpaEntity toEntity(Member member) {
        return MemberJpaEntity.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }

    public Member toDomain(MemberJpaEntity memberJpaEntity) {
        return Member.builder()
                .id(memberJpaEntity.getId())
                .name(memberJpaEntity.getName())
                .build();
    }
}
