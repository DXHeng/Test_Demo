package com.xio.study.aop;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理
 */

public class C_CglibProxy {

    @Test
    public void fun01() {

        final UserDaoImpl03 userDao03 = new UserDaoImpl03();

        //创建enhancer对象
        Enhancer enhancer = new Enhancer();

        //设置代理的父类
        enhancer.setSuperclass(UserDaoImpl03.class);

        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if ("save".equals(method.getName())) {
                    System.out.println("权限校验...");
                    return method.invoke(userDao03, args);
                }

                return method.invoke(userDao03, args);
            }
        });

        UserDaoImpl03 userDaoProxy = (UserDaoImpl03) enhancer.create();
        userDaoProxy.save();
        userDaoProxy.delete();
        
    }

}

class UserDaoImpl03 {


    public void save() {
    }

    public void delete() {
    }
}