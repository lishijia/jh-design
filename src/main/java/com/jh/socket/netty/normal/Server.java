package com.jh.socket.netty.normal;

import com.jh.socket.netty.normal.out.AOutHandler;
import com.jh.socket.netty.normal.out.BOutHandler;
import com.jh.socket.netty.normal.out.COutHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-26 10:28
 **/
public class Server {

    public static void main(String args[]) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    //BACKLOG用于构造服务端套接字ServerSocket对象，标识当服务器请求处理线程全满时，
                    //用于临时存放已完成三次握手的请求的队列的最大长度。如果未设置或所设置的值小于1，Java将使用默认值50。
                    .childOption(ChannelOption.SO_BACKLOG, 100)
                    //设置这样做好的好处就是禁用nagle算法 nagle是尽可能的把小包合并发送一个大包，最大延迟500ms
                    .childOption(ChannelOption.TCP_NODELAY, true)
//                    .handler(new ServerHandler())
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("init Channel");
                            ChannelPipeline channelPipeline = ch.pipeline();
//                            channelPipeline.addLast(new AInHander());
//                            channelPipeline.addLast(new BInHandler());
//                            channelPipeline.addLast(new CInHandler());
                            channelPipeline.addLast(new AOutHandler());
                            channelPipeline.addLast(new BOutHandler());
                            channelPipeline.addLast(new COutHandler());
                        }
                    });

            ChannelFuture channelFuture = b.bind(6379).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
