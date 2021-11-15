package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class L_677 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app",2);
        System.out.println(mapSum.sum("ap"));
        mapSum = new MapSum();
        mapSum.insert("apple",3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app",2);
        System.out.println(mapSum.sum("ap"));
    }
}
class MapSum {
    static class classNode{
        classNode[] maps;
        int cur = 0;
        classNode(){
            maps =  new classNode[26];
        }
    }
    HashMap<String,Integer> map;
    classNode head;
    public MapSum() {
        map  = new HashMap<>();
        head = new classNode();
    }

    public void insert(String key, int val) {
        Integer t = map.get(key);
        if(t != null){

            classNode cur1 = head,u ;
            for(int i = 0; i < key.length(); i++){
                u = cur1.maps[key.charAt(i)-'a'];

                u.cur += val-t;
                cur1 = u;
            }
        }
        else {

            classNode cur1 = head,u ;
            for(int i = 0; i < key.length(); i++){
                u = cur1.maps[key.charAt(i)-'a'];
                if (u == null){
                    u = cur1.maps[key.charAt(i)-'a']= new classNode();

                }
                u.cur += val;
                cur1 = u;
            }
        }
        map.put(key,val);
    }

    public int sum(String prefix) {

        classNode cur1 = head,u ;
        for (int i = 0; i < prefix.length()  && cur1 != null; i++){
            u = cur1.maps[prefix.charAt(i)-'a'];
            cur1 = u;
        }
        if (cur1 != null){
            return cur1.cur;
        }else  return 0;

    }
}