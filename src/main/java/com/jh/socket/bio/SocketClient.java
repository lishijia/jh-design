package com.jh.socket.bio;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-1517:18
 **/
public class SocketClient {

    @Test
    public void client() throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 6379));


        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("first message".getBytes());
        outputStream.write("second message".getBytes());

        outputStream.close();
        socket.close();

    }

}
