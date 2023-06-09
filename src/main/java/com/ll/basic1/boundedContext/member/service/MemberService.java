package com.ll.basic1.boundedContext.member.service;

import com.ll.basic1.base.rsData.RsData;
import com.ll.basic1.boundedContext.member.entity.Member;
import com.ll.basic1.boundedContext.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// @Component : 아래 클래스의 객체는 Ioc 컨테이너에 의해 생사소멸 관리된다.
// @Service : @Component 와 같은 의미, 가독성 때문에 이렇게 표기
@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public RsData tryLogin(String username, String password) { // 로그인을 시도
        Member member = memberRepository.findByUsername(username).orElse(null); // 멤버리포지터리에 username과 같은 id가 있는지 찾음

        if (member == null) { // member가 null이면 에러 출력
            return RsData.of("F-2", "%s(은)는 존재하지 않는 회원입니다.".formatted(username));
        }

        if (!member.getPassword().equals(password)) {
            return RsData.of("F-1", "비밀번호가 일치하지 않습니다.");
        }

        return RsData.of("S-1", "%s 님 환영합니다.".formatted(username), member); // 성공 시 출력
    }

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username).orElse(null);
    }

    public Member findById(long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member join(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .build();

        memberRepository.save(member);

        return member;
    }
}