package hello.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findById(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findById() {
    }
}