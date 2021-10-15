package com.company;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman12 {
    static Map<Integer,String> map = new HashMap<>();
    static int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static {
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

    }

    public int getIndex(int[] nums,int num){
        int l=0,r = nums.length-1,mid;
        while (l <= r){
            mid= (l+r)>>1;
            if(nums[mid] > num){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return l;
    }
    public String intToRoman(int num){
        StringBuilder ans = new StringBuilder();
        int t;
        while (num!=0){
             int i = getIndex(nums,num);
                t = num/nums[i];
                while (t > 0){
                    ans.append(map.get(nums[i]));
                    t--;
                    num -= nums[i];
                }


        }
        return ans.toString();
    }
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman1(int num){

            StringBuffer roman = new StringBuffer();
            roman.append(thousands[num / 1000]).append(hundreds[num % 1000 / 100]).append(tens[num % 100 / 10]).append(ones[num % 10]);
            return roman.toString();

    }

    public static void main(String[] args) {
        System.out.println(new IntToRoman12().intToRoman(1994));
        System.out.println(new IntToRoman12().intToRoman(3994));
        System.out.println(new IntToRoman12().intToRoman1(3994));
    }
}
