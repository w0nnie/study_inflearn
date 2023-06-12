package study.hellospring2.repository;

import org.springframework.stereotype.Repository;
import study.hellospring2.domain.Member;

import java.util.List;
import java.util.Optional;


/**
 * 기능: 회원 등록, 조회
 */
@Repository
public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
