package org.example.core.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.example.core.domain.member.Member;
import org.example.core.infrastructure.repository.mapper.MemberPersistenceMapper;
import org.example.core.infrastructure.repository.model.MemberJpaEntity;
import org.example.core.domain.member.MemberRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final JpaMemberRepository jpaMemberRepository;
    private final MemberPersistenceMapper memberPersistenceMapper;


    @Override
    public Member save(Member member) {
        MemberJpaEntity entity = memberPersistenceMapper.toEntity(member);
        return memberPersistenceMapper.toDomain(jpaMemberRepository.save(entity));
    }

    @Override
    public Member findById(Long id) {
        MemberJpaEntity memberJpaEntity = jpaMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 멤버를 찾을 수 없습니다."));
        return memberPersistenceMapper.toDomain(memberJpaEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaMemberRepository.deleteById(id);
    }
}
