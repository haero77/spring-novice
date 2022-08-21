package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { // "/hello" 로 들어오면 이 메서드를 호출
        model.addAttribute("data", "hello!!! this is attributeValue!");
        return "hello"; // resources/templates/hello.html 로 이동하라
    }
}
