package com.jh.design.strategy;

/**
 * @program:
 * @description: 定义下单模型(子类不同的业务走不同侧策略)
 * @author: lishijia
 * @create: 2019-03-1210:33
 **/
public interface IPlaceHandler {

    void place();

}
