package com.ddd.application.member.in;

import com.ddd.domain.member.Member;
import com.ddd.domain.member.MemberRegisterRequest;
import jakarta.validation.Valid;

public interface MemberRegister {
    Member register(@Valid MemberRegisterRequest registerRequest);
}
