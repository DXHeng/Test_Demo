package com.xio.study.rpc.rpc1;

import com.xio.study.rpc.rpc1.client.Client;
import com.xio.study.rpc.rpc1.server.IHelloService;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RpcTest {
    public static void main(String[] args) throws IOException {

        IHelloService service = Client.getRemoteProxyObj(
                IHelloService.class,
                new InetSocketAddress("localhost", 8080)
        );

        System.out.println(service.sayHi("张三", "新年快乐，大吉大利!"));

    }
}
