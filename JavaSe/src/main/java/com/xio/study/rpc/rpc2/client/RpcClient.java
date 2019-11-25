package com.xio.study.rpc.rpc2.client;

import com.xio.study.rpc.rpc2.client.proxy.RpcProxyClient;
import com.xio.study.rpc.rpc2.server.service.IHello;
import com.xio.study.rpc.rpc2.server.service.impl.HelloService;


/**
 * 客户端调用
 */
public class RpcClient {


    // 调用服务
    public static void main(String[] args) {

        RpcProxyClient<HelloService> rpcClient = new RpcProxyClient<>();

        Object o = rpcClient.proxyClient(HelloService.class);

        IHello hello = (IHello) o;

        String s = hello.sayHello("我是熊恒");

        System.out.println(s);

    }
}