package com.ll.basic1.boundedContext.member.service;

import com.ll.basic1.base.reData.RsData;
import com.ll.basic1.boundedContext.member.entity.Member;
import com.ll.basic1.boundedContext.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

// @Component : 아래 클래스의 객체는 Ioc 컨테이너에 의해 생산소멸 관리된다.
// @Service : @Component 와 같은 의미, 가독성 때문에 이렇게 표기
@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }
    public RsData tryLogin(String username, String password) {
        Member member = memberRepository.findByUsername(username); // 멤버 저장소에서 아이디가 일치하는 member객체를 반환

        if (member == null) {
            //멤버가 없으면
            return RsData.of("F-2", "%s(은)는 존재하지 않는 회원입니다.".formatted(username));
        }
        if (!member.getPassword().equals(password)) {
            // 일치하는 회원의 비밀번호가 다르면
            return RsData.of("F-1", "비밀번호가 일치하지 않습니다.");
        }

        // 멤버가 존재하고 비밀번호가 일치하면 성공적으로 로그인이 된 것
        return RsData.of("S-1", "%s 님 환영합니다.".formatted(username));

    }
}

