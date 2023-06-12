package study.hellospring2;

import com.sun.jdi.PathSearchingVirtualMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.hellospring2.aop.TimeTraceAop;
import study.hellospring2.repository.*;
import study.hellospring2.service.MemberService;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//    private EntityManager entityManager;
//    @Autowired
//    public SpringConfig(DataSource dataSource, EntityManager entityManager) {
//        this.dataSource = dataSource;
//        this.entityManager = entityManager;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //Bean 객체 만들어줄껀데

    //configuration 어노테이션이 springApplication이 실행되면서 어떻게 동작하는지가 알고싶다.

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return timeTraceAop();
//    }

    // 기존에 Memory를 이용한 구현체에서 Jdbc repo로 변경
//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(entityManager);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource);
//    }


}
