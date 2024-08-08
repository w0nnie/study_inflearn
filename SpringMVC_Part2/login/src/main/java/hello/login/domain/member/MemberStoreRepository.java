package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberStoreRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        log.info("save: member={}", member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        Member member = store.get(id);
        return member;
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
//        List<Member> list = findAll();
//        for (Member member : list) {
//            if (member.getLoginId().equals(loginId)) {
//                return Optional.of(member);
//            }
//        }
//        return Optional.empty();

        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId)).
                findFirst();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
