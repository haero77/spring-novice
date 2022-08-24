package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 컴포넌트 스캔. 스프링 빈으로 자동 등록된다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
    public MemberController(MemberService memberService) { // MemberService 역시 스프링 빈에 등록되어있어야 한다.
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm memberForm) { // memberForm의 name필드에 html에서 입력한 name 값이 들어온다.
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println("member.getName() = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "/members/memberList";
    }

}
