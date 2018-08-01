package com.xu.combootcomponnent.service.impl;

import com.xu.combootcomponnent.entity.UserEntity;
import com.xu.combootcomponnent.mapper.UserMapper;
import com.xu.combootcomponnent.service.InterfaceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuhongda on 2018/8/1
 * com.xu.combootcomponnent.service.impl
 * com-boot-ex
 */
@Service
public class InterfaceTestImpl implements InterfaceTest {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserEntity getoneUser(long id) {
        return userMapper.getOne(1L);
    }
}
