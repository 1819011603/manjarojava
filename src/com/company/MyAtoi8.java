package com.company;

public class MyAtoi8 {
    public int myAtoi(String s){
        boolean f = true;
        long ans  = 0;
        int i = 0;
        while ( i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        if (i>= s.length())return 0;
        if(s.charAt(i) == '-'){
            f = false;
            i++;
        }
        else if( s.charAt(i) == '+'){
            i++;
        }

        for (; i < s.length(); i++){
             if(s.charAt(i) <= '9' && s.charAt(i) >= '0'){

                ans = ans * 10 + s.charAt(i) - '0';
                if(ans-1 > Integer.MAX_VALUE )break;
            }else break;
        }


        if (!f){
            ans = -ans;
            if(ans < Integer.MIN_VALUE)ans = Integer.MIN_VALUE;
        }
        if(ans > Integer.MAX_VALUE)ans = Integer.MAX_VALUE;
        return (int) ans;
    }
    public static void main(String[] args) {
        System.out.println(new MyAtoi8().myAtoi("42"));
        System.out.println(new MyAtoi8().myAtoi("   -42"));
        System.out.println(new MyAtoi8().myAtoi("4913 with words"));
        System.out.println(new MyAtoi8().myAtoi("words and 987"));
        System.out.println(new MyAtoi8().myAtoi("-91283472332"));
        System.out.println(new MyAtoi8().myAtoi("+1"));
        System.out.println(new MyAtoi8().myAtoi("++1"));
        System.out.println(new MyAtoi8().myAtoi("+-1"));
        System.out.println(new MyAtoi8().myAtoi("-+1"));
        System.out.println(new MyAtoi8().myAtoi("+-1"));
        System.out.println(new MyAtoi8().myAtoi("    +"));

    }
}
