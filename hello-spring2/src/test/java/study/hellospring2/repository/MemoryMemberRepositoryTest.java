package study.hellospring2.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.hellospring2.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();


    /**
     * 테스트는 순서에 의존하면 안된다. 순서와 상관없이 테스트가 수행되어야함
     * 그러기위에서는 save,findById,Name을 통해 생성된 Member객체를
     * 저장하는 Map 자료구조를 test메서드가 실행되고 나서 clear해준 후 다른 test메서드에 진입한다.
     */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {

        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        List<Member> members = repository.findAll();

        assertThat(members.size()).isEqualTo(2);

    }
}