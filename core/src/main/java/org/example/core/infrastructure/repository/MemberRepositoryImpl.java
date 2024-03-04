package org.example.core.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.example.core.domain.Member;
import org.example.core.infrastructure.repository.mapper.MemberPersistenceMapper;
import org.example.core.infrastructure.repository.model.MemberJpaEntity;
import org.example.core.domain.MemberRepository;
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
                .orElseThrow(IllegalArgumentException::new);
        return memberPersistenceMapper.toDomain(memberJpaEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaMemberRepository.deleteById(id);
    }
}
