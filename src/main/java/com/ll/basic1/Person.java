package com.ll.basic1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor // 안의 멤버변수를 모두 포함한 생성자를 자동으로 생성(롬복)
@Getter // 개별적으로 포함 시키고 싶으면 변수에 하나씩 따로 붙이면 된다.
@ToString
class Person {
    private static int lastId;
    private int id;
    @Getter
    private String name;
    private int age;

    static {
        lastId = 0;
    }
    public Person(String name, int age) {
        this(++lastId, name, age);
    }
}
