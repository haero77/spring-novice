package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 정적 컨텐츠
    @GetMapping("hello")
    public String hello(Model model) { // "localhost:8080/hello" 로 들어오면 이 메서드를 호출
        model.addAttribute("data", "hello!!! this is attributeValue!");
        return "hello"; // resources/templates/hello.html 로 이동하라
    }

    // MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name); // key: "name", value: name
        return "hello-template";
    }

    // API 방식 - @Response바디 문자 반환
    @GetMapping("hello-string")
    @ResponseBody // HTTP의 BODY에 문자 내용을 직접 반환
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 문자 반환 -> StringConverter 동작
    }

    // API 방식 - @Response바디 객체 반환
    @GetMapping("hello-api")
    @ResponseBody // HTTP의 BODY에 문자 내용을 직접 반환
    public Hello helloAPI(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체 반환 -> JsonConverter 동작
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
