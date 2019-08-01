package com.jh.socket.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Random;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-16 14:17
 **/
public class NioClient {

    protected final Selector selector = SelectorProvider.provider().openSelector();
    private Random rnd = new Random();

    public NioClient() throws IOException {
    }

    @Test
    public void client() throws IOException, InterruptedException {
        NioClient nioClient = new NioClient();
        nioClient.initCient();
        nioClient.handle();
    }

    public void initCient() throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        sc.register(selector, interestSet);
        sc.connect(new InetSocketAddress("127.0.0.1",6379));

        while(!sc.finishConnect()) {
            ;
        }
        System.out.println("finish connect");
    }

    public void handle() throws IOException, InterruptedException {
        while (true) {
            selector.select();

            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()){

                SelectionKey key = keys.next();
                keys.remove();

                SocketChannel sc = (SocketChannel) key.channel();

                if(key.isReadable()){
                    ByteBuffer readByffer = ByteBuffer.allocate(1024);
                    sc.read(readByffer);
                    readByffer.flip();

                    System.out.println(new String(readByffer.array()));

                    readByffer.clear();
                } else if(key.isWritable()){
                    ByteBuffer writerBuffer = ByteBuffer.allocate(1024);
                    writerBuffer.put("1214HELLO, WORLD".getBytes());

                    writerBuffer.flip();

                    sc.write(writerBuffer);

                    writerBuffer.clear();
                    System.out.println("finish write");
                }

            }

            Thread.sleep(1000 + rnd.nextInt(1000));

        }
    }

}
