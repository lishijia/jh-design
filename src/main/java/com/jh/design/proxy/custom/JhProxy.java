package com.jh.design.proxy.custom;

import com.jh.design.proxy.Person;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class JhProxy {

    public static Object newProxyInstance(JhClassLoader loader,
                                          Class<?>[] interfaces,
                                          JhInvocationHandler h)
            throws Exception {

        //1.生成代理类源码($Proxy0.java)
        String src = genSrc(interfaces[0]);

        String filePath = JhProxy.class.getResource("").getPath();
        File file = new File(filePath + "$Proxy0.java");
        FileWriter fw = new FileWriter(file);
        fw.write(src);
        fw.flush();
        fw.close();

        //2.动态编译.java文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = fileManager.getJavaFileObjects(file);

        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();

        //3.加载class文件至jvm
        System.out.println(filePath+"$Proxy0.class");
        Class proxyClass = loader.findClass("$Proxy0");
//        Class proxyClazz = loader.findClass("E:/work/javaP/jh-design/target/classes/com/jh/design/proxy/custom/$Proxy0.class");
        Constructor c = proxyClass.getConstructor(JhInvocationHandler.class);
        //file.delete();

        return c.newInstance(h);
    }

    private static String ln = "\r\n";
    private static String genSrc(Class<?> interfaces){
        StringBuffer buffer = new StringBuffer();
        buffer.append("package com.jh.design.proxy.custom;" + ln );
        buffer.append("import java.lang.reflect.Method;" + ln);
        buffer.append("public final class $Proxy0 implements " + interfaces.getName() + " {" + ln);


        buffer.append("protected JhInvocationHandler h;" + ln);

        buffer.append("public $Proxy0(JhInvocationHandler h){"+ ln);
        buffer.append("this.h = h;" + ln);
        buffer.append("}" + ln);

        for(Method m : interfaces.getMethods()){
            buffer.append("public " + m.getReturnType() + " " + m.getName() + "(){" + ln);
            buffer.append("try{" + ln);
            buffer.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
            buffer.append("this.h.invoke(this, m, null);" + ln);
            buffer.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            buffer.append("}" + ln);
        }

        buffer.append("}");

        return buffer.toString();
    }

    public static void main(String args[])throws Exception{
        newProxyInstance(null,new Class[]{Person.class},null);
    }


}
