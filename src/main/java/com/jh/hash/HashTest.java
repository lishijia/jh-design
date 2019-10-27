package com.jh.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-26 15:24
 **/
public class HashTest {

    public static void main(String[] args){
        Map<Object, Object> map = new HashMap<>();
        for(int i=0;i<1000;i++){
            map.put(i, i);
        }
//        new ArrayList<>();
//        new HashMap<>();
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
