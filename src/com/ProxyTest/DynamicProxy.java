package com.ProxyTest;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynamicProxy {

    public static void main(String[] args) {

        Car f = (Car) Proxy.newProxyInstance(CarImpl.class.getClassLoader(), CarImpl.class.getInterfaces(),new InvocationHandlerImpl(new CarImpl()));
        f.buy();
        f.sail();
        createProxyClassFile();

    }
    private static void createProxyClassFile(){
        String name = "/home/lenong0427/IdeaProjects/test/src/com/ProxyTest/ProxyCar";
        byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{CarImpl.class});
        FileOutputStream out =null;
        try {
            out = new FileOutputStream(name+".class");
            System.out.println(name);
            out.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
