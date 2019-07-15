package com.jh.io;

import org.junit.Test;

import java.io.*;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-15 17:50
 **/
public class IOTest {


    @Test
    public void test1()throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input char");
        char c;
        c = (char)reader.read();
        System.out.println("you put the char is " + c);
    }

    @Test
    public void test2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input char");
        String c = "";
        do{
            c =  reader.readLine();
            System.out.println("you put the char is " + c);
        }while(!c.equals("quit"));
        System.out.println("finish input");
    }

    @Test
    public void test3() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\lishijia.txt"));
        writer.write("通过字符流写入字符");
        writer.write("abcdef", 1, 3); //从索引1位置开始写入，写两个2字符
        writer.flush();
        writer.close();
        System.out.println("finish the test3 method");
    }

    @Test
    public void test4() throws IOException{
        FileInputStream inputStream = new FileInputStream("D:\\bin32_64\\setup.ini");
        byte[] bytes = new byte[512];
        int len = 0;
        StringBuffer buffer = new StringBuffer();
        while( (len = inputStream.read(bytes)) != -1){
            String s = new String(bytes,0, len);
            buffer.append(s);
        }
        System.out.println(buffer.toString());
    }

    @Test
    public void test5() throws IOException{
        FileInputStream inputStream = new FileInputStream("D:\\bin32_64\\setup.ini");
        FileOutputStream outputStream = new FileOutputStream("d:\\lishijia.txt");
        byte[] bytes = new byte[512];
        int len = 0;
        while ( (len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, len);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }

    @Test
    public void test6() throws IOException{
        /**
         *  使用缓存冲流
         */
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\bin32_64\\setup.ini"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("d:\\lishijia.txt"));

        byte[] bytes = new byte[512];
        int len = 0;
        while( (len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, len);
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }

}
