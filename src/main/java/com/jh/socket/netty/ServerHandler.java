package com.jh.socket.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-2610:33
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("handlerAdded");
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 耗时的操作
                String result = loadFromDB();

                ctx.channel().writeAndFlush(result);
                ctx.executor().schedule(new Runnable() {
                    @Override
                    public void run() {
                        // ...
                    }
                }, 1, TimeUnit.SECONDS);

            }
        }).start();
    }

    private String loadFromDB() {
        return "hello world!";
    }
}
