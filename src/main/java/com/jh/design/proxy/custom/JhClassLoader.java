package com.jh.design.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class JhClassLoader extends ClassLoader {

    private File baseDir;

    public JhClassLoader() {
        String basePath = JhClassLoader.class.getResource("").getPath();
        this.baseDir = new java.io.File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        File classFile = new File(classPath);
        String className = JhClassLoader.class.getPackage().getName() + "." + name;
        File classFile = new File(baseDir,name.replaceAll("\\.", "/") + ".class");
        if (classFile.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                return defineClass(className, out.toByteArray(), 0, out.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return null;

    }
}
