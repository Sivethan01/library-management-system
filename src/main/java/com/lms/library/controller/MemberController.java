package com.lms.library.controller;

import com.lms.library.model.Member;
import com.lms.library.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() { return memberService.getAllMembers(); }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable int id) { return memberService.getMember(id); }

    @PostMapping
    public Member addMember(@Valid @RequestBody Member newMember) {
        return memberService.addMember(newMember);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id,@Valid @RequestBody Member updatedMember) {
        return memberService.updateMember(id, updatedMember);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable int id) {
        return memberService.deleteMember(id);
    }
}
