package com.ddd.application.member;

import com.ddd.application.member.in.MemberRegister;
import com.ddd.application.member.out.MemberRepository;
import com.ddd.domain.member.Member;
import com.ddd.domain.member.MemberRegisterRequest;
import com.ddd.domain.member.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberModifyService implements MemberRegister {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberRegisterRequest registerRequest) {
        if (memberRepository.findByNickname(registerRequest.nickname())) {
            throw new IllegalStateException("등록된 닉네임입니다.");
        }

        return Member.register(registerRequest, passwordEncoder);
    }

}
