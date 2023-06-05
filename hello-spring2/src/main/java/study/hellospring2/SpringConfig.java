package study.hellospring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.hellospring2.repository.JdbcMemberRepository;
import study.hellospring2.repository.MemberRepository;
import study.hellospring2.repository.MemoryMemberRepository;
import study.hellospring2.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //Bean 객체 만들어줄껀데

    //configuration 어노테이션이 springApplication이 실행되면서 어떻게 동작하는지가 알고싶다.

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    
    // 기존에 Memory를 이용한 구현체에서 Jdbc repo로 변경
    @Bean
    public MemberRepository memberRepository(){
        return new JdbcMemberRepository(dataSource);
    }


}
