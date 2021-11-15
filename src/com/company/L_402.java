package com.company;

public class L_402 {

    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < num.length(); i++){
            while (stack.length() > 0 &&  k > 0&& stack.charAt(stack.length()-1) > num.charAt(i)){
                    stack.deleteCharAt(stack.length()-1);
                    k--;
            }
            stack.append(num.charAt(i));
        }
        if (k > 0){
            while (k-- != 0){
                stack.deleteCharAt(stack.length()-1);
            }
        }
        while (stack.length() > 0 && stack.charAt(0) == '0'){
            stack.deleteCharAt(0);
        }
        if (stack.length() == 0)stack.append(0);
        return  stack.toString();
    }
    public String removeKdigits1(String num, int k) {
        StringBuilder stack = new StringBuilder();
        int m = num.length()-k;
        for (int i = 0; i < num.length(); i++){
            while (stack.length() > 0 && stack.charAt(stack.length()-1) > num.charAt(i)){
                if (stack.length() + num.length()- i > m){
                    stack.deleteCharAt(stack.length()-1);
                }else break;
            }
            if (stack.length() < m)
            stack.append(num.charAt(i));
        }
        while (stack.length() > 0 && stack.charAt(0) == '0'){
            stack.deleteCharAt(0);
        }
        if (stack.length() == 0)stack.append(0);
        return  stack.toString();
    }

    public static void main(String[] args) {

        System.out.println(new L_402().removeKdigits("10",2));
        System.out.println(new L_402().removeKdigits("1432219",6));
        System.out.println(new L_402().removeKdigits("1432219",3));
        System.out.println(new L_402().removeKdigits("10200",1));
        System.out.println(new L_402().removeKdigits("122313123124",4));
    }
}
