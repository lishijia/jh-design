package com.jh.socket.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-16 14:17
 **/
public class NioServer {

    protected final Selector selector = SelectorProvider.provider().openSelector();
    private ServerSocketChannel serverSocketChannel = null;

    public NioServer() throws IOException {
    }

    @Test
    public void server() throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.initServer();
        nioServer.handleAccpet();
    }

    public void initServer() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        // 将channel设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(6379));

        // 注册连接监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void handleAccpet() throws IOException {
        System.out.println("等待连接");
        while (true) {
            selector.select();

            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            while(selectionKeys.hasNext()){
                SelectionKey selectionKey = selectionKeys.next();
                selectionKeys.remove();
                if(selectionKey.isAcceptable()){
                    SocketChannel sc = serverSocketChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    System.out.println("client connect");
                } else if (selectionKey.isReadable()){
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    sc.read(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array()));
                    byteBuffer.clear();
                    selectionKey.interestOps(SelectionKey.OP_WRITE);
                } else if(selectionKey.isWritable()) {
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("hello client".getBytes());
                    byteBuffer.flip();
                    int len = 0;
                    while ( byteBuffer.hasRemaining()){
                        len = sc.write(byteBuffer);
                        if(len==0){
                            break;
                        }
                    }
                    byteBuffer.clear();
                    if(len != 0 ){
                        selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                }
            }

        }
    }

}
