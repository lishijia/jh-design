package com.jh.socket.netty.rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-08-02 10:36
 **/
public class RcpClient {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new RequestEncoder());
                        }
                    });
            ChannelFuture channelFuture = b.connect("127.0.0.1", 6379).sync();
            String body = "this message is from client";
            channelFuture.channel().writeAndFlush(new RequestParam((byte) 1, (byte) 1, body.length(), body));
            channelFuture.channel().writeAndFlush(new RequestParam((byte) 2, (byte) 2, body.length(), body));
            System.out.println("message already send.");
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}
