package com.ll.basic1;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;

@Controller
// @Controller 의 의미
// 개발자가 스프링부트에게 말한다.
// 아래 있는 HomeController 는 컨트롤러이다.
public class HomeController {
    private int id;
    private List<Person> people;

    public HomeController() {
        this.id = 0;
        people = new ArrayList<>();
    }

    // @GetMapping("/home/main") 의 의미
    // 개발자가 스프링부트에게 말한다.
    // 만약에 /home/main 이런 요청이 오면 아래 메서드를 실행해줘
    @GetMapping("/home/main")
    // @ResponseBody 의 의미
    // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    @ResponseBody
    public String showMain() {
        return "안녕하세요!!";
    }

    @GetMapping("/home/main2")
    // @ResponseBody 의 의미
    // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    @ResponseBody
    public String showMain2() {
        return "반갑습니다.";
    }

    @GetMapping("/home/main3")
    // @ResponseBody 의 의미
    // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    @ResponseBody
    public String showMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    // @ResponseBody 의 의미
    // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    @ResponseBody
    public int showIncrese() {
        return id++;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    //@RequestParam
    // 개발자가 스프링 부트에게 말한다.
    // 생략 가능
    public int showPlus(@RequestParam(defaultValue = "1") int a, int b) {
        return a + b;
    }

    // 다양한 리턴 타입으로 응답해보기
    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean showReturnBoolean() {
        return true;
    }

    @GetMapping("/home/returnDouble")
    @ResponseBody
    public double showReturnDouble() {
        return Math.PI;
    }

    @GetMapping("/home/returnIntArray")
    @ResponseBody
    public int[] showReturnIntArray() {
        int[] arr = new int[]{10, 20, 30};

        return arr;
    }

    @GetMapping("/home/returnIntList")
    @ResponseBody
    public List<Integer> showReturnIntList() {
        List<Integer> list = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
        }};

        return list;
    }

    @GetMapping("/home/returnMap")
    @ResponseBody
    public Map<String, Object> showReturnMap() {
        Map<String, Object> map = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "카니발");
            put("relatedIds", new ArrayList<>() {{
                add(2);
                add(3);
                add(4);
            }});
        }};

        return map;
    }

    @GetMapping("/home/returnCar")
    @ResponseBody
    public Car showReturnCar() {
        Car car = new Car(1, 100, "카니발", new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});

        return car;
    }

    @GetMapping("/home/returnCarV2")
    @ResponseBody
    public CarV2 showReturnCarV2() {
        CarV2 car = new CarV2(1, 100, "카니발", new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});

        car.setName(car.getName() + "V2");

        return car;
    }

    @GetMapping("/home/returnCarMapList")
    @ResponseBody
    public List<Map<String, Object>> showReturnCarMapList() {
        Map<String, Object> carMap1 = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "카니발");
            put("relatedIds", new ArrayList<>() {{
                add(2);
                add(3);
                add(4);
            }});
        }};

        Map<String, Object> carMap2 = new LinkedHashMap<>() {{
            put("id", 2);
            put("speed", 200);
            put("name", "포르쉐");
            put("relatedIds", new ArrayList<>() {{
                add(5);
                add(6);
                add(7);
            }});
        }};

        List<Map<String, Object>> list = new ArrayList<>();

        list.add(carMap1);
        list.add(carMap2);

        return list;
    }

    @GetMapping("/home/returnCarList")
    @ResponseBody
    public List<CarV2> showReturnCarList() {
        CarV2 car1 = new CarV2(1, 100, "카니발", new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});

        CarV2 car2 = new CarV2(2, 200, "포르쉐", new ArrayList<>() {{
            add(5);
            add(6);
            add(7);
        }});

        List<CarV2> list = new ArrayList<>();

        list.add(car1);
        list.add(car2);

        return list;
    }

    @GetMapping("/home/addPerson")
    @ResponseBody
    public String addPerson(String name, int age) {
        Person p = new Person(name, age);

        System.out.println(p);

        people.add(p);

        return "%d번 사람이 추가되었습니다.".formatted(p.getId());
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> showPeople() {
        return people;
    }

    @GetMapping("/home/removePerson")
    @ResponseBody
    public String removePerson(int id) {
        // person -> person.getId() == id
        // 위 함수가 참인 엘리먼트(요소) 경우가 존재하면, 해당 요소를 삭제한다.
        // removed 에는 삭제수행여부가 저장된다.
        // 조건에 맞는걸 찾았고 삭제까지 되었다면 true, 아니면 false
        boolean removed = people.removeIf(person -> person.getId() == id);

        //        스트림 사용하지 않고 삭제하는 방법
//        for ( Person p : people ) {
//            if ( p.getId() == id ) people.remove(p);
//        }

        if (removed == false) {
            return "%d번 사람이 존재하지 않습니다.".formatted(id);
        }

        return "%d번 사람이 삭제되었습니다.".formatted(id);
    }

    @GetMapping("/home/modifyPerson")
    @ResponseBody
    public String modifyPerson(int id, String name, int age) {

        // 사람 있는지 체크
        Person found = people
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null); // 없으면 null을 반환해라
        if (found == null) {
            return "%d 번이 없습니다".formatted(id);
        }

        found.setName(name);
        found.setAge(age);

        return "%d 번이 수정되었습니다".formatted(id);
    }

    @GetMapping("/home/cookie/increase")
    @ResponseBody
    public int showCookieIncrease(HttpServletRequest req, HttpServletResponse resp) throws IOException { // 리턴되는 int 값은 String 화 되어서 고객(브라우저)에게 전달된다.
//        int countInCookie = 0;
//
//        Cookie[] cookies = req.getCookies(); // request 객체에서 쿠키 객체를 얻어옴
//        if (cookies != null) { // 쿠키 객체가 존재하면
//            for (Cookie c : cookies) { // 쿠키객체들을 읽어서
//                countInCookie = Integer.valueOf(c.getValue()); // 쿠키 객체의 value값을 읽어옴
//            }
//        } else { // 쿠키 없으면 0으로
//            countInCookie = 0;
//        }
//
//        int increasedValue = countInCookie + 1; // 쿠키로 얻어온 값을 증가시켜서
//        resp.addCookie(new Cookie("value", increasedValue + "")); // 응답 객체의 쿠키 값을 변경
//
//        return increasedValue;

//        강사님이 작성한 브라우저 별로 쿠키를 주어 카운트를 다르게 하기 실습
//        // 고객이 가져온 쿠폰에서 count 쿠폰을 찾고 그 쿠폰의 값을 가져온다.
//        if (req.getCookies() != null) {
//            countInCookie = Arrays.stream(req.getCookies())
//                    .filter(cookie -> cookie.getName().equals("count"))
//                    .map(Cookie::getValue)
//                    .mapToInt(Integer::parseInt)
//                    .findFirst()
//                    .orElse(0);
//        }
//
//        int newCountInCookie = countInCookie + 1;
//
//        // 고객이 가져온 count 쿠폰값에 1을 더한 쿠폰을 만들어서 고객에게 보낸다.
//        // 쉽게 말하면 브라우저(고객)에 저장되어 있는 count 쿠폰의 값을 1 증가시킨다.
//        // 이렇게 브라우저의 쿠키값을 변경하면 재방문시에 스프링부트가 다시 그 값을 받게 되어 있다.
//        resp.addCookie(new Cookie("count", newCountInCookie + ""));
//
//        // 응답 본문
//        return newCountInCookie;

        // 다시 해보기

        int cookieCount = 0;

        Cookie[] cookies = req.getCookies(); // 쿠키를 얻어옴

        if (cookies != null) { // 쿠키가 있다면
            for (Cookie c : cookies) {
                cookieCount = Integer.valueOf(c.getValue());
            }
        } else {
            // null이면
            cookieCount = 0;
        }

        int newCookieCount = cookieCount + 1;


        resp.addCookie(new Cookie("value", String.valueOf(newCookieCount)));

        return newCookieCount;
    }

    @GetMapping("member/login")
    @ResponseBody
    public Map<String, String> showLogin(String username, String password) {
        Map<String, String> map = new HashMap<>();

        if (username.equals("user1") && password.equals("1234")) {
            map.put("resultCode", "S-1");
            map.put("msg", "user1님 환영합니다.");
        } else if (!username.equals("user1")) {
            map.put("resultCode", "F-2");
            map.put("msg", "user2(은)는 존재하지 않는 회원입니다.");
        } else if (!password.equals("1234")) {
            map.put("resultCode", "F-1");
            map.put("msg", "비밀번호가 일치하지 않습니다.");
        }

        return map;
    }
}

