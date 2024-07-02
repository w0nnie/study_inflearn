package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {

        //given ->주어짐
        Member member = new Member("hello", 20);

        //when -> 실행함
        memberRepository.save(member);

        //then -> 예상결과
        Member findMember = memberRepository.findById(member.getId());
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findAll() {
        //given
        Member member = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        //when
        memberRepository.save(member);
        memberRepository.save(member2);

        //then -> member의 총 count가 나와야함
        List<Member> memberList = memberRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(2);
        Assertions.assertThat(memberList).contains(member, member2);
    }

    @Test
    void clearStore() {
    }
}