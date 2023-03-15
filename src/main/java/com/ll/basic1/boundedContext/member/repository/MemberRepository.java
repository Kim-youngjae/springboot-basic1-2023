package com.ll.basic1.boundedContext.member.repository;

import com.ll.basic1.boundedContext.member.entity.Member;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MemberRepository {
    List<Member> members;

    //리스트 초기화
    public MemberRepository() {
        members = new ArrayList<>(); // 리스트를 초기화 해줌
        // 생성자로 데이터 넣어주기
        members.add(new Member("user1", "1234"));
        members.add(new Member("abc", "12345"));
        members.add(new Member("test", "12346"));
        members.add(new Member("love", "12347"));
        members.add(new Member("like", "12348"));
        members.add(new Member("giving", "12349"));
        members.add(new Member("thanks", "123410"));
        members.add(new Member("hello", "123411"));
        members.add(new Member("good", "123412"));
        members.add(new Member("peace", "123413"));
    }

    public Member findByUsername(String username) {
        return members
                .stream()
                .filter(m -> m.getUsername().equals(username)) // username과 같은 멤버객체를 필터
                .findFirst() //처음 나온 것을 찾음
                .orElse(null); // 없으면 null을 반환
    }
}
