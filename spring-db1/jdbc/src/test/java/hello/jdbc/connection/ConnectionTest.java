package hello.jdbc.connection;


import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class ConnectionTest {

    @Test
    void driverManager() throws SQLException {
        Connection connection1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Connection connection2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        log.info("connection1: {}, class ={}", connection1, connection1.getClass());
        log.info("connection2: {}, class ={}", connection2, connection2.getClass());
    }

    @Test
    void dataSourceDriverManager() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        useDataSource(dataSource);
    }

    @Test
    void dataSourceConnectionPool() throws SQLException, InterruptedException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(11);
        dataSource.setPoolName("myPool");

        useDataSource(dataSource);
    }

    private void useDataSource(DataSource datasource) throws SQLException {
        Connection conn1 = datasource.getConnection();
        Connection conn2 = datasource.getConnection();
        Connection conn3 = datasource.getConnection();
        Connection conn4 = datasource.getConnection();
        Connection conn5 = datasource.getConnection();
        Connection conn6 = datasource.getConnection();
        Connection conn7 = datasource.getConnection();
        Connection conn8 = datasource.getConnection();
        Connection conn9 = datasource.getConnection();
        Connection conn10 = datasource.getConnection();
        Connection conn11 = datasource.getConnection();
        log.info("connection1: {}, class ={}", conn1, conn1.getClass());
        log.info("connection2: {}, class ={}", conn2, conn2.getClass());
        log.info("connection3: {}, class ={}", conn3, conn3.getClass());
        log.info("connection4: {}, class ={}", conn4, conn4.getClass());
        log.info("connection5: {}, class ={}", conn5, conn5.getClass());
        log.info("connection6: {}, class ={}", conn6, conn6.getClass());
        log.info("connection7: {}, class ={}", conn7, conn7.getClass());
        log.info("connection8: {}, class ={}", conn8, conn8.getClass());
        log.info("connection9: {}, class ={}", conn9, conn9.getClass());
        log.info("connection10: {}, class ={}", conn10, conn10.getClass());
        log.info("connection11: {}, class ={}", conn11, conn11.getClass());
    }

}
