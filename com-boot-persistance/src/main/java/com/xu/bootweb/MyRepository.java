package com.xu.bootweb;

import entity.UserEntity;
import org.springframework.stereotype.Repository;

import static enums.UserSexEnum.MAN;

/**
 * @author xuhongda on 2018/9/8
 * com.xu.bootweb
 * com-boot-ex
 */
@Repository
public class MyRepository {
    /**
     *
     * @return UserEntity
     */
    public UserEntity get(){
        return new UserEntity(1L,"xu","123",MAN,"xx");
    }
}
