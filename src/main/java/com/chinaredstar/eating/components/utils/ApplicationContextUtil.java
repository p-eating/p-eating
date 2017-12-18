package com.chinaredstar.eating.components.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 上下文
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 18:30 2017/12/18
 * @modified by:
 */
@Configuration
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取上下文
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return ApplicationContextUtil.applicationContext;
    }

}
