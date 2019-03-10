package com.jh.design.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Test {

    public static void main(String args[]) throws Exception {
        /**
         * 原理：
         * 1. 动态代理AgentProxy拿到代理对象
         * 2. JDK动态生成一个代理类（Proxy$），这个类实现动态代理对象所实现的接口
         * 3. 把动态代理对象的引用也拿到（在新生成的类中）
         * 4. 编辑运行
         */
        Person person = (Person)new AgentProxy().getInstance(new JohnPerson());
//        Person person = (Person)Proxy.newProxyInstance(john.getClass().getClassLoader(), john.getClass().getInterfaces(), proxy);
        person.findHouse();

        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("$Proxy0.class");
        os.write(data);
        os.close();



        /**
         * 以下为生成的代理对象内容，当中实现了Person接口，并且把持有了target对象。可以看到生成的对象当中，包括了所有target里面的一些信息都生成好了
         * import com.jh.design.proxy.Person;
         import java.lang.reflect.InvocationHandler;
         import java.lang.reflect.Method;
         import java.lang.reflect.Proxy;
         import java.lang.reflect.UndeclaredThrowableException;

         public final class $Proxy0 extends Proxy
         implements Person
         {
         private static Method m1;
         private static Method m3;
         private static Method m2;
         private static Method m0;

         public $Proxy0(InvocationHandler paramInvocationHandler)
         throws
         {
         super(paramInvocationHandler);
         }

         public final boolean equals(Object paramObject)
         throws
         {
         try
         {
         return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
         }
         catch (RuntimeException localRuntimeException)
         {
         throw localRuntimeException;
         }
         catch (Throwable localThrowable)
         {
         throw new UndeclaredThrowableException(localThrowable);
         }
         }

         public final void findHouse()
         throws
         {
         try
         {
         this.h.invoke(this, m3, null);
         return;
         }
         catch (RuntimeException localRuntimeException)
         {
         throw localRuntimeException;
         }
         catch (Throwable localThrowable)
         {
         throw new UndeclaredThrowableException(localThrowable);
         }
         }

         public final String toString()
         throws
         {
         try
         {
         return (String)this.h.invoke(this, m2, null);
         }
         catch (RuntimeException localRuntimeException)
         {
         throw localRuntimeException;
         }
         catch (Throwable localThrowable)
         {
         throw new UndeclaredThrowableException(localThrowable);
         }
         }

         public final int hashCode()
         throws
         {
         try
         {
         return ((Integer)this.h.invoke(this, m0, null)).intValue();
         }
         catch (RuntimeException localRuntimeException)
         {
         throw localRuntimeException;
         }
         catch (Throwable localThrowable)
         {
         throw new UndeclaredThrowableException(localThrowable);
         }
         }

         static
         {
         try
         {
         m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
         m3 = Class.forName("com.jh.design.proxy.Person").getMethod("findHouse", new Class[0]);
         m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
         m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
         return;
         }
         catch (NoSuchMethodException localNoSuchMethodException)
         {
         throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
         }
         catch (ClassNotFoundException localClassNotFoundException)
         {
         throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
         }
         }
         }
         */
    }

}
