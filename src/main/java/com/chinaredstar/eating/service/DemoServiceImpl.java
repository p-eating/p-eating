package com.chinaredstar.eating.service;

import com.chinaredstar.eating.mapper.DemoMapper;
import com.chinaredstar.eating.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public User findUser() {
        return demoMapper.findUser();
    }
}
