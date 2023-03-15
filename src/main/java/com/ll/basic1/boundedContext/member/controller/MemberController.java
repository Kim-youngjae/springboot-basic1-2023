package com.ll.basic1.boundedContext.member.controller;

import com.ll.basic1.base.reData.RsData;
import com.ll.basic1.boundedContext.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MemberController {
    private final MemberService memberService; // 멤버 컨트롤러에서는 멤버 서비스에 요청

    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/login")
    @ResponseBody
    public RsData login(String username, String password) {
//        Map<String, Object> rsData = new LinkedHashMap<>() {{
//            put("resultCode", "S-1");
//            put("msg", "%s 님 환영합니다.".formatted(username));
//        }};

        return memberService.tryLogin(username, password); // 로그인이 가능한지 아닌지 판단은 멤버 서비스에서 함
    }
}

