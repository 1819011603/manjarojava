package com.company;
import java.util.*;

public class L_5896 {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1,10);
        stockPrice.update(2,5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1,3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4,2);
        System.out.println(stockPrice.minimum());
    }
}

class StockPrice {
    Integer now = 0;
    // TreeMap  价格，该价格的数量的映射
    TreeMap<Integer,Integer> price_nums;
    // HashMap  时间戳，价格的映射
    HashMap<Integer,Integer> map;
    public StockPrice() {
        now = 0;
        map = new HashMap<>();
        price_nums = new TreeMap<>();
    }



    public void update(int timestamp, int price) {

        if (timestamp > now)now = timestamp;

        if (map.containsKey(timestamp)){
            int old = map.get(timestamp);
            int i = price_nums.get(old) - 1;
            if (i == 0){
                price_nums.remove(old);
            }else {
                price_nums.put(old, i);
            }
        }
        price_nums.put(price, price_nums.getOrDefault(price,0)+1);
        map.put(timestamp,price);


    }

    public int current() {
        return map.get(now);
    }

    public int maximum() {
        // 获得最大值
        return price_nums.lastKey();
    }

    public int minimum() {
        // 获得最小值
        return price_nums.firstKey();
    }

}
