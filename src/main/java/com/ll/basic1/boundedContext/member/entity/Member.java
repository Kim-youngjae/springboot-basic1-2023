package com.ll.basic1.boundedContext.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Member {
    static long lastId;
    long id;
    String username;
    String password;

    static {
        lastId = 0; // static 변수 초기화
    }

    public Member(String username, String password) {
        this(++lastId, username, password);
    }
}
