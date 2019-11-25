package com.xio.study.aop;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理：
 *  这一种主要是针对有接口实现的情况。
 *  它的底层是创建接口的实现代理类，实现扩展功能。
 *  也就是我们要增强的这个类，实现了某个接口，那么我就可以使用这种方式了
 */
public class B_JDKProxy {

    @Test
    public void fun01() {
        final UserDao userDao = new UserDaoImpl02();
        UserDao proxyDao = (UserDao)
                Proxy.newProxyInstance(
                        userDao.getClass().getClassLoader(),// 类加载器
                        userDao.getClass().getInterfaces(), // 接口
                        new InvocationHandler() {           //
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                if ("save".equals(method.getName())) {
                                    System.out.println("权限校验...");
                                    return method.invoke(userDao, args);
                                }
                                return method.invoke(userDao, args);
                            }
                        }
                );
        proxyDao.save();
    }

}

class UserDaoImpl02 extends UserDao {

}

class UserDao {

    public void save() {

    }
}