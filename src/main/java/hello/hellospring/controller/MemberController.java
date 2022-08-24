package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 컴포넌트 스캔. 스프링 빈으로 자동 등록된다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
    public MemberController(MemberService memberService) { // 넣어주려고 봤는데, MemberService가 스프링 빈으로 등록되어 있지 않아 오류 발생
        this.memberService = memberService;
    }
}
