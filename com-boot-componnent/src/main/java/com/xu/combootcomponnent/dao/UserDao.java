package com.xu.combootcomponnent.dao;

import com.xu.combootcomponnent.entity.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/2
 * com.xu.combootcomponnent.dao
 * com-boot-ex
 */
@Component
public class UserDao {
    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public UserEntity getById(long id){
       return sqlSession.selectOne("getOne",id);
    }
}
