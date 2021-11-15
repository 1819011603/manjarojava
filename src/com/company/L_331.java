package com.company;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_331 {
    public boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Deque<String> stack = new LinkedList<>();
        stack.push(strings[0]);
        int i = 1;

        while (!stack.isEmpty() && i < strings.length){
            if(strings[i].equals("#")){

                if(stack.peekLast().equals("#")){
                    while (stack.size()>1 && stack.peekLast().equals("#")){
                        stack.pollLast();
                        if ("#".equals(stack.pollLast()))return false;
                    }

                    stack.addLast(strings[i++]);
                }else  stack.addLast(strings[i++]);



            }else{
                stack.addLast(strings[i++]);

            }


        }
        return stack.size() == 1 && stack.peekLast().equals("#");

    }

    public static void main(String[] args) {
        System.out.println(new L_331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new L_331().isValidSerialization("1,#"));
        System.out.println(new L_331().isValidSerialization("9,#,#,1"));
    }
}
