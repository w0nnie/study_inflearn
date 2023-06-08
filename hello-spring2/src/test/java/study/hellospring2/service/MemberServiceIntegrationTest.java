package study.hellospring2.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.hellospring2.domain.Member;
import study.hellospring2.repository.MemberRepository;
import study.hellospring2.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // :  스프링 컨테이너와 테스트를 함께 실행한다
@Transactional //  : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고,  테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지않는다.
class MemberServiceIntegrationTest {

    @Autowired
    MemberService service;

    @Autowired
    MemberRepository repository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long id = service.join(member);

        //then
        Member findMember = service.findOne(id).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member = new Member();
        member.setName("spring");

        Member member1 = new Member();
        member1.setName("spring");

        //when
        service.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member1));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


//        try {
//            service.join(member1);
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then
    }

    @Test
    void finMembers() {
    }

    @Test
    void findOne() {
    }
}