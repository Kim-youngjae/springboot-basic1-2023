package com.ll.basic1.boundedContext.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // db화 되는 클래스로 분류 된다.
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id // id를 주 키로 설정한다는 어노테이션
    @GeneratedValue(strategy = IDENTITY) // auto_increment 옵션
    private long id;
    private LocalDateTime createDate; // 데이터 생성 날짜
    private LocalDateTime modifyDate; // 데이터 수정 날짜
    private String title;
    private String body;
}
