package com.jh.socket.testnio;

import java.nio.ByteBuffer;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-18 14:20
 **/
public class Buffers {

    ByteBuffer readBuffer;
    ByteBuffer writeBuffer;

    public Buffers(int readCapacity, int writeCapacity){
        readBuffer = ByteBuffer.allocate(readCapacity);
        writeBuffer = ByteBuffer.allocate(writeCapacity);
    }

    public ByteBuffer getReadBuffer(){
        return readBuffer;
    }

    public ByteBuffer gerWriteBuffer(){
        return writeBuffer;
    }
}
