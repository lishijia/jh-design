package com.jh.socket.netty.rpc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-08-02 10:47
 **/
public class RequestEncoder extends MessageToByteEncoder<RequestParam> {

    @Override
    protected void encode(ChannelHandlerContext ctx, RequestParam requestParam, ByteBuf out) throws Exception {
        if( requestParam == null){
            throw new Exception("request param null");
        }
        out.writeByte(requestParam.getType());
        out.writeByte(requestParam.getFlag());
        out.writeInt(requestParam.getLength());
        out.writeBytes(requestParam.getBody().getBytes());
    }

}
