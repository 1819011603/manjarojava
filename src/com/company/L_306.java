package com.company;

public class L_306 {

    public boolean isAdditiveNumber(String num) {
        char[] chars = num.toCharArray();
        int i = 0;
        int u = Math.min(chars.length-2,10);
        while ( i < u){
            int j = i+1;

            long first = Long.parseLong(new String(chars,0,i+1));
            while (j < chars.length-1 ){
                if(chars.length-j < j-i || j-i > 10)break;
                long second  = Long.parseLong(new String(chars,i+1,j-i));

                if(helper(chars,first,second,j+1))return true;

                j++;
                if(second == 0)break;

            }
            if(first == 0)return false;
            i++;

        }
        return false;
    }

    public boolean helper(char[] s,long first,long second,int start){
        if (start == s.length){

            return true;
        }


        int i = start;

        while (i < s.length && (i-start+1 <= 10)){
            long third = Long.parseLong(new String(s,start,i-start+1));
            if(first + second > third){
                i++;

            }else if(first + second < third)return false;
            else {
                if( helper(s,second,third,i+1))return true;
                i++;

            }
            if(third == 0)return false;
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(new L_306().isAdditiveNumber("1002003005008001300"));
    }
}
