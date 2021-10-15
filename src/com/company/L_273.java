package com.company;

public class L_273 {
    public String numberToWords(int num) {
        String[] strings = new String[]{
                "Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"
        };
        String[] strings1 = new String[]{
                "Zero","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"
        };
        String[] strings2 = new String[]{
              "","Thousand","Million","Billion"
        };
        String nums = String.valueOf(num);
        int length = nums.length(),t;
        int i = 0;
        StringBuilder ans = new StringBuilder();
        int n;
        while (i < length){
            t = (length-i-1)/3;
            n = (length-i) % 3;
            if (n == 1){
                ans.append(strings[nums.charAt(i)-'0']).append(" ");
                i++;
            }else if (n == 2){
                if (nums.charAt(i) > '1'){
                    ans.append(strings1[nums.charAt(i)-'0']).append(" ");
                    if (nums.charAt(i+1) != '0'){
                        ans.append(strings[nums.charAt(i+1)-'0']).append(" ");
                    }
                }else {
                    int s= Integer.parseInt(nums.substring(i,i+2));
                    ans.append(strings[s]).append(" ");
                }

                i+=2;
            }else {
                if (nums.charAt(i)!='0'){
                    ans.append(strings[nums.charAt(i)-'0']).append(" ").append("Hundred ");
                }
                if (nums.charAt(i+1) > '1'){
                    ans.append(strings1[nums.charAt(i+1)-'0']).append(" ");
                    if (nums.charAt(i+2) != '0'){
                        ans.append(strings[nums.charAt(i+2)-'0']).append(" ");
                    }
                }else {
                    int s= Integer.parseInt(nums.substring(i+1,i+3));
                    if (s!=0)
                    ans.append(strings[s]).append(" ");
                }

                i+=3;
            }
            if (t != 0){
                if (n == 0){
                    int p = Integer.parseInt(nums.substring(i-3,i));
                    if (p!=0)
                        ans.append(strings2[t]).append(" ");

                }else ans.append(strings2[t]).append(" ");
            }


        }
        if (ans.charAt(ans.length()-1) == ' ')ans.deleteCharAt(ans.length()-1);



        return ans.toString();
    }
    public static void main(String[] args) {

        System.out.println(new L_273().numberToWords(101001000));
        System.out.println(new L_273().numberToWords(10000000));

    }
}
