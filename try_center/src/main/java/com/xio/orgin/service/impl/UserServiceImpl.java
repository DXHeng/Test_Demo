package com.xio.orgin.service.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author: polarbear
 * @Date: 2019/7/8 15:47
 * @Description: Test_Demo
 */
@Component
// 默认是单例的
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements Runnable {

    @Override
    public void run() {

    }


}
