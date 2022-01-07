package com.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class InvocationHandlerImpl implements InvocationHandler
 {
     private Object subject;
     InvocationHandlerImpl(Object s){
         subject = s;
     }

     @Override
     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         if(method.getName().equals("sail")){
             return null;
         }
         System.out.println("pre invoke");
         Object v = method.invoke(subject,args);
         System.out.println("behind invoke");
         return v;
     }

     public static void main(String[] args) {

     }
 }
