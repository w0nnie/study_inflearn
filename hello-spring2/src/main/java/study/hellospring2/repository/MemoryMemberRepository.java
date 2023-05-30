package study.hellospring2.repository;

import study.hellospring2.domain.Member;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 아직 데이터 저장소가 선정되지 않음(가상의 시나리오)
 * 해당 강의에서는 store라는 Map자료구조 구현체를 통해 구현한다.
 */
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * stream 같은경우 optional로 감싸지 않아도되는가?
     *  findAny()의 결과가 없을 경우도 생각해야 하기 때문에 Optional로 반환됩니다.
     */
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return store.values().stream().collect(Collectors.toList());
    }
}
