package com.jh.socket.netty.in;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-30 10:54
 **/
public class AInHander extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("this is AInbound handler " + msg);
        ctx.fireChannelRead(msg);
    }
}
