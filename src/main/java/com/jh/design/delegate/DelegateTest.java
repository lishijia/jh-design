package com.jh.design.delegate;

/**
 * @program:委派模式
 * @description: 委派模式不属于 23 种设计模式之一，是面向对象设计模式中常用的一种模式。这种模式的原理为类 B
和类 A 是两个互相没有任何关系的类，B 具有和 A 一模一样的方法和属性；并且调用 B 中的方法，属性
就是调用 A 中同名的方法和属性。B 好像就是一个受 A 授权委托的中介。第三方的代码不需要知道 A 的
存在，也不需要和 A 发生直接的联系，通过 B 就可以直接使用 A 的功能，这样既能够使用到 A 的各种功
能，又能够很好的将 A 保护起来了，一举两得。
 * @author: lishijia
 * @create: 2019-03-11 15:45
 **/
public class DelegateTest {

    public static void main(String args[]){

        IExecutor executor = new SimpleExecutor();
        //executor.query();

        CachingExecutor cachingExecutor = new CachingExecutor(executor, false);
        cachingExecutor.query();
    }

}
