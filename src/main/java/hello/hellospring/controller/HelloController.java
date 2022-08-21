package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { // "localhost:8080/hello" 로 들어오면 이 메서드를 호출
        model.addAttribute("data", "hello!!! this is attributeValue!");
        return "hello"; // resources/templates/hello.html 로 이동하라
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name); // key: "name", value: name
        return "hello-template";
    }
}
