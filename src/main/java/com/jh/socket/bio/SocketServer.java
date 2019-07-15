package com.jh.socket.bio;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-15 17:18
 **/
public class SocketServer {

    @Test
    public void server() throws IOException {
        ServerSocket server = new ServerSocket(6379);
        System.out.println("the server is start");
        // 阻塞等待客户端连接
        Socket socket = server.accept();
        // 一般来了连接后都是开一个线程去专门处理这个客户端
        System.out.println("client connected");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ( (len = inputStream.read(bytes)) != -1){
            System.out.println("server receive data from client。 the data is = " + new String(bytes, 0, len));
            outputStream.write(bytes);
        }
        inputStream.close();
        outputStream.close();
        server.close();
    }

}
