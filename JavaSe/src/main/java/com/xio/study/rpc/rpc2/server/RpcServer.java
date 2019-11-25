package com.xio.study.rpc.rpc2.server;

import com.xio.study.rpc.rpc2.server.proxy.RpcProxyServer;

/**
 * 服务端发布服务
 */
public class RpcServer {
    //发布服务
    public static void main(String[] args) {
        System.out.println("服务端发布服务");
        RpcProxyServer server = new RpcProxyServer();
        server.publisherServer(8000);

    }
}