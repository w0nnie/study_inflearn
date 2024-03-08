package com.thinking.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BookMyBatisDAO { // MyBatis API
    // DB연결 -> config.xml(환경설정파일) -> API read 연결작업을 대신 해주면 된다.
    private static SqlSessionFactory sqlSessionFactory; // Connection(SqlSession) Pool
    static{  // 초기화 블럭
        try{
            String resource = "mybatis-config/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
