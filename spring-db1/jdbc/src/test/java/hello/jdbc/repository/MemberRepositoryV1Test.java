package hello.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.connection.ConnectionConst;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static hello.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repo;

    @BeforeEach
    void beforeEach() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repo = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException, InterruptedException {
        log.info("start");

        //save
        Member member = new Member("memberV0", 10000);
        repo.save(member);

        //findById
        Member memberById = repo.findById(member.getMemberId());
        assertThat(memberById).isNotNull();

        //update: money: 10000 -> 20000
        repo.update(member.getMemberId(), 20000);
        Member updatedMember = repo.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        //delete
        repo.delete(member.getMemberId());
        assertThatThrownBy(() -> repo.findById(member.getMemberId())).isInstanceOf(NoSuchElementException.class);
    }
}