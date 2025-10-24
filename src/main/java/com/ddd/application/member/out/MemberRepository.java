package com.ddd.application.member.out;

import com.ddd.domain.member.Member;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface MemberRepository extends Repository<Long, Member> {
    Member save(Member member);

    boolean findByNickname(String nickname);
}
