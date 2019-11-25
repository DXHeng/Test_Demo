package com.xio.study.rpc.rpc2.client.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 1.构建一个Socket，连接远程服务。
 * 2.向远程服务发送数据。（方法名和方法参数）
 * 3.接收远程服务响应的数据。
 * @param <T>
 */
public class RpcProxyClient<T> {

    public Object proxyClient(Class<T> clazz) {

        return
               // clazz.cast(
                Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    clazz.getInterfaces(),
                    (proxy, method, args) -> {
                        // -----
                        try (Socket socket = new Socket("localhost", 8000)) {
                            try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
                                oos.writeUTF(method.getName());
                                oos.writeObject(args);
                                oos.flush();
                                try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                                    return ois.readObject();
                                }
                            }
                        }
                        // -----
                    }
                );
      //  );
    }
}