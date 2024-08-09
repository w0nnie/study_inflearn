package hello.login.web.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberStoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberStoreRepository memberRepository;


    public Optional<Member> login(LoginForm member) {
        Optional<Member> byLoginId = memberRepository.findByLoginId(member.getLoginId());

        if (byLoginId.isPresent() && byLoginId.get().getPassword().equals(member.getPassword())) {
            return byLoginId;
        }

        return Optional.empty();
    }

}
