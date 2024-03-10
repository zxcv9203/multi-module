package org.example.core.application;

import lombok.RequiredArgsConstructor;
import org.example.core.domain.member.Member;
import org.example.core.domain.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void save(String name) {
        Member member = Member.builder()
                .name(name)
                .build();

        memberRepository.save(member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
