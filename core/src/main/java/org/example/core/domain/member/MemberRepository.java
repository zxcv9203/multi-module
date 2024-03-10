package org.example.core.domain.member;

public interface MemberRepository {
    Member save(Member member);

    Member findById(Long id);

    void deleteById(Long id);
}
