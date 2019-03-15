package com.zhangbin.user.service.impl;

import com.zhangbin.common.DateUtils;
import com.zhangbin.user.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String userTest() {
        return "Hello, This is a Project For SpringBoot, {User Module Test}  ToDay : " + DateUtils.getDateTime("");
    }

}
