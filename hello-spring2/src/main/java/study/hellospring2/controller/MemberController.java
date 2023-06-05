package study.hellospring2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.hellospring2.domain.Member;
import study.hellospring2.domain.MemberForm;
import study.hellospring2.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberSerivce;

    @Autowired
    public MemberController(MemberService memberSerivce) {
        this.memberSerivce = memberSerivce;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @GetMapping("/members")
    public String memberList(Model model) {
        //memberService finMembers 메서드 조회
        List<Member> members = memberSerivce.finMembers();
        model.addAttribute("members" , members);
        return "members/memberList";
    }

    @PostMapping("members/new")
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());
        memberSerivce.join(member);

        return "redirect:/";
    }
}
