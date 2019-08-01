package com.jh.socket.netty.normal.out;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-30 11:18
 **/
public class COutHandler extends ChannelOutboundHandlerAdapter{
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("COutHandler: " + msg);
        ctx.write(msg);
    }
}
