package com.jh.socket.netty.normal.out;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-30 11:17
 **/
public class AOutHandler extends ChannelOutboundHandlerAdapter{

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("AOutHandler: " + msg);
        ctx.write(msg);
    }

    @Override
    public void handlerAdded(final ChannelHandlerContext ctx) {
        ctx.executor().schedule(() -> {
            ctx.channel().write("hello world");
//            ctx.write("hello world");
        }, 4, TimeUnit.SECONDS);
    }
}
