package com.jh.design.single;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-1111:54
 **/
public class Single2 {

    private static Single2 single2 = null;

    private Single2() {
    }

    public static Single2 getInstance() {
        if (single2 == null) {
            synchronized (Single2.class) {
                if (single2 == null) {
                    single2 = new Single2();
                }
            }
        }
        return single2;
    }


}
