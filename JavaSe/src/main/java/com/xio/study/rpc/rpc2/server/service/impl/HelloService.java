package com.xio.study.rpc.rpc2.server.service.impl;

import com.xio.study.rpc.rpc2.server.service.IHello;

public class HelloService implements IHello {

    @Override
    public String sayHello(String info) {
        String result = "hello : " + info;
        System.out.println(result);
        return result;
    }

}