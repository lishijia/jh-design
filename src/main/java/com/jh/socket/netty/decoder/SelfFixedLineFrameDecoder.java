package com.jh.socket.netty.decoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-08-01 17:23
 **/
public class SelfFixedLineFrameDecoder extends MessageToMessageDecoder<String> {

    @Override
    protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println("received msg := " + msg + " out size = " + out.size());
    }
}
