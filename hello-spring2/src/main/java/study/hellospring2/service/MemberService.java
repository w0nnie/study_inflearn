package study.hellospring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.hellospring2.domain.Member;
import study.hellospring2.repository.MemberRepository;
import study.hellospring2.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * 같은 이름이 있는 중복 회원 X
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateDuplacteMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체회원조회
     */
    public List<Member> finMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원아이디로 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    /**
     * 중복회원 조회
     * ifPresent Optional 객체가 값을 가지고 있으면 실행 값이 없으면 넘어감
     * 이
     */
    private void validateDuplacteMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
