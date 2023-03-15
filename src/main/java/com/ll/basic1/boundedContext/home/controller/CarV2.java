package com.ll.basic1.boundedContext.home.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
//@Getter
class CarV2 {
    private final int id;
    @Getter
    private final int speed;
    @Setter
    @Getter
    private String name;
    private final List<Integer> relatedIds;
}
