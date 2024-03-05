package org.example.api.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.example.api.infrastructure.rest.request.MemberCreateRequest;
import org.example.core.application.MemberService;
import org.example.core.domain.Member;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @PostMapping
    public void save(@RequestBody MemberCreateRequest request) {
        memberService.save(request.name());
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
    }
}
