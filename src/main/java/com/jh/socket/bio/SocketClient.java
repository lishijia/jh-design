package com.jh.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-15 17:18
 **/
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 6379));
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readData = null;
        do {
            readData = reader.readLine();
            outputStream.write(readData.getBytes());
        } while (!"quit".equals(readData));
        outputStream.close();
        socket.close();
    }

}
