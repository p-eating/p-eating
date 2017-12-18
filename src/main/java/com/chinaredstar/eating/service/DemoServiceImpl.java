package com.chinaredstar.eating.service;

import com.chinaredstar.eating.mapper.UserMapper;
import com.chinaredstar.eating.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserMapper demoMapper;

    @Override
    public UserModel findUser() {
        return demoMapper.findUser();
    }
}
