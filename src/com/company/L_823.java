package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class L_823 {

    public static int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i: arr){
            map.put(i, 1);
        }
        int n = arr.length;
        long temp = 0;
        long ans = 0;
        for (int i = 0;i < n-1; i++){
            for (int j = 0; j <=i ; j++){
                temp = (long) arr[i] * arr[j];
                if (temp > 1e9)break;
                if (map.containsKey((int)temp)){
                    if ( arr[i]  ==  arr[j]){
                        map.put((int) temp, (int) ((map.get((int)temp)+(long)map.get(arr[i]) * map.get(arr[j]))% (1e9+7)));
                    }else map.put((int) temp, (int) ((map.get((int)temp)+(long)map.get(arr[i]) * map.get(arr[j]) *2)% (1e9+7)));
                }
            }
        }
        for (Integer i:map.values()){
            ans += i;

        }
        return (int) (ans%(1e9+7));
    }

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[]{2,4,5,10,20}));
    }
}
