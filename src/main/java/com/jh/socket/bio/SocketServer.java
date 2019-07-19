package com.jh.socket.bio;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
        while(true) {
            System.out.println("main thread wait for client to connect");
            Socket socket = server.accept();
            System.out.println("client connected");
            Thread socketWorkThread = new Thread(new Worker(socket));
            socketWorkThread.start();
        }

    }

    static class Worker implements Runnable{
        private Socket socket;

        public Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                // 一般来了连接后都是开一个线程去专门处理这个客户端
                System.out.println("socket worker thread wait client to send data");
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println("server receive data from client。 the data is = " + new String(bytes, 0, len));
                }
            }catch (IOException e){
            }finally {
                try {
                    if(inputStream!=null){
                        inputStream.close();
                    }
                    socket.close();
                }catch (IOException e){}
            }
        }
    }

}
