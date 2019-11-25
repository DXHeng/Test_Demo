package com.xio.study.rpc.rpc2.server.proxy;

import com.xio.study.rpc.rpc2.server.service.IHello;
import com.xio.study.rpc.rpc2.server.service.impl.HelloService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. 构建一个ServerSocket服务监听来自客户端的请求。
 * 2.接收请求的数据。（方法名和参数）
 * 3.根据请求的数据（方法名和参数），使用反射调用相应的服务。
 * 4.输出服务的响应数据。
 */
public class RpcProxyServer {

    private IHello hello = new HelloService();

    public void publisherServer(int port) {

        try (ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = ss.accept()) {
                    try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                        String method = ois.readUTF();

                        Object[] objs = (Object[]) ois.readObject();

                        Class<?>[] types = new Class[objs.length];


                        for (int i = 0; i < types.length; i++) {
                            types[i] = objs[i].getClass();
                        }

                        Method m = HelloService.class.getMethod(method, types);

                        Object obj = m.invoke(hello, objs);

                        try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
                            oos.writeObject(obj);
                            oos.flush();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}