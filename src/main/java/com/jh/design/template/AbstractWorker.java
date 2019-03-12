package com.jh.design.template;

/**
 * @program:
 * @description: 定义模板步骤（模板模式）
 * @author: lishijia
 * @create: 2019-03-12 10:25
 **/
public abstract class AbstractWorker implements IWorker {

    public void process() {

        queryData();

        queryFailData();

        handleNotify();

    }

    abstract void queryData();

    abstract void queryFailData();

    abstract void handleNotify();


}
