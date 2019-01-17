package com.xu.bootweb.controller;

import com.xu.bootweb.exception.ZeRoException;
import com.xu.bootweb.mapper.TTokenMapper;
import com.xu.bootweb.mapper.TUserMapper;
import com.xu.bootweb.pojo.TToken;
import com.xu.bootweb.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xuhongda on 2019/1/12
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
@RequestMapping("t")
public class TransactionController {
    private final TUserMapper tUserMapper;

    private final TTokenMapper tTokenMapper;

    @Autowired
    public TransactionController(TUserMapper tUserMapper, TTokenMapper tTokenMapper) {
        this.tUserMapper = tUserMapper;
        this.tTokenMapper = tTokenMapper;
    }

    /**
     * 数据库事务
     */
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("t1")
    public void t1() {
        TUser tUser = new TUser();
        tUser.setUsername("xcv");
        tUser.setLoginacct(new Date().toString());
        tUser.setEmail("xxx");
        tUser.setUserpswd("1234");
        tUserMapper.insertSelective(tUser);
        m1();
    }

    private void m1() {
        TToken tToken = new TToken();
        tToken.setToken("str");
        tToken.setUid(11111);
        tToken.setCreatetime(new Date());
        tTokenMapper.insertSelective(tToken);
        throw new ZeRoException("ex");
    }
}
