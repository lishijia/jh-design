package com.jh.socket.netty.rpc;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-08-021 0:12
 **/
public class RequestParam {
    /**
     * 类型数值以后扩展1,2,3......
     */
    private byte type;
    /**
     * 信息标志  1:表示心跳包 2:业务信息包
     */
    private byte flag;
    /**
     * 请求消息内容长度
     */
    private int length;
    /**
     * 请求消息体
     */
    private String body;

    public RequestParam(byte type, byte flag, int length, String body) {
        this.type = type;
        this.flag = flag;
        this.length = length;
        this.body = body;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RequestParam{" +
                "type=" + type +
                ", flag=" + flag +
                ", length=" + length +
                ", body='" + body + '\'' +
                '}';
    }
}
