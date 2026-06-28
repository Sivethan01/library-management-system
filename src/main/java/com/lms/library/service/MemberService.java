package com.lms.library.service;

import com.lms.library.exception.ResourceNotFoundException;
import com.lms.library.model.Member;
import com.lms.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(int id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member Not Found"));
    }

    public Member addMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    public Member updateMember(int id, Member updatedMember) {
        if(memberRepository.existsById(id)) {
            updatedMember.setId(id);
            return memberRepository.save(updatedMember);
        }
        throw new ResourceNotFoundException("Member Not Found");
    }

    public String deleteMember(int id) {
        if(memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return "Member Deleted Successfully";
        }
        throw new ResourceNotFoundException("Member Not Found");
    }
}
