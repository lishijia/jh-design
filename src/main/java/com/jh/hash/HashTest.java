package com.jh.hash;

import java.util.HashMap;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-26 15:24
 **/
public class HashTest {

    public static void main(String[] args){
        for(int i=0;i<1000;i++){
            System.out.println(hash(i));
        }
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
