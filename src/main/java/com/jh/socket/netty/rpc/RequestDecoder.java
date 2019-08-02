package com.jh.socket.netty.rpc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-08-0210:18
 **/
public class RequestDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //注意在读的过程中，readIndex的指针也在移动
        byte type = in.readByte();
        byte flag = in.readByte();
        int length = in.readInt();
        String body = null;
        if (length > 0){
            ByteBuf buf = in.readBytes(length);
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            body = new String(req, "UTF-8");
        }
        RequestParam requestParam = new RequestParam(type,flag,length,body);
        out.add(requestParam);
    }

}
