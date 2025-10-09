package com.ddd.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ddd.domain.member.MemberFixture.createMemberRegisterRequest;
import static com.ddd.domain.member.MemberFixture.createPasswordEncoder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    Member member;
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        this.passwordEncoder = createPasswordEncoder();
        member = Member.register(createMemberRegisterRequest(), passwordEncoder);
    }

    @Test
    void registerMember() {
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
        assertThat(member.getNickname()).isNotNull();
        assertThat(member.getPasswordHash()).isNotNull();
    }

    @Test
    void registerFail() {
        MemberRegisterRequest request = new MemberRegisterRequest(null, null);

        assertThatThrownBy(() -> Member.register(request, passwordEncoder))
                .isInstanceOf(NullPointerException.class);
    }

}