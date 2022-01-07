package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationHandler;
import java.net.Proxy;
import java.util.TreeMap;

public class L_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        while(map.size()>0){
            int k = groupSize-1;
            Integer start = map.firstKey();
            int v = map.get(start);
            map.remove(start);
            while(k--!=0){
                Integer p = map.get(++start);
                if(p== null || p < v){
                    return false;
                }
                if(p == v) map.remove(start);
                else map.put(start,p-v);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
