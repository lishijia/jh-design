package com.jh.socket.netty.normal.in;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-30 10:57
 **/
public class CInHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("this is Cinbound handler " + msg);
    }
}
