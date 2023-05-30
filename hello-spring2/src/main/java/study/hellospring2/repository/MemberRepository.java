package study.hellospring2.repository;

import study.hellospring2.domain.Member;

import java.util.List;
import java.util.Optional;


/**
 * 기능: 회원 등록, 조회
 */
public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    void clearStore();
}
