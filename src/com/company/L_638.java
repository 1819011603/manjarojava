package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class L_638 {
    int sum = 0;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        for (int j = 0; j < special.size(); j++){
            List<Integer> o1 = special.get(j);
            int a = 0;
            boolean f = false;
            for (int i = 0; i < price.size(); i++){
                a+=price.get(i) *o1.get(i);
                if (o1.get(i) > needs.get(i)){
                    f = true;
                    break;
                }
            }
            a-= o1.get(price.size());

            if (a <= 0 || f){
                special.remove(j);
                j--;
            }
        }
        for (int i = 0; i < needs.size(); i++){
            sum += needs.get(i)* price.get(i);
        }
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < price.size(); i++){
            cur.add(0);
        }
        cur.add(0);
        dfs(price,special,needs,cur);
        return sum;
    }

    public void dfs(List<Integer> price,List<List<Integer>> special,List<Integer> needs,List<Integer> cur){
        boolean f = false;
        for (List<Integer> l: special){
            boolean b = false;
            for (int i = 0; i < needs.size(); i++){
                if (needs.get(i) - cur.get(i) < l.get(i)){
                    b = true;
                    break;
                }
            }
            if (!b){
                f = true;
                for (int i = 0; i <= needs.size(); i++){
                    cur.set(i,cur.get(i) + l.get(i));
                    }

                dfs(price,special,needs,cur);
                for (int i = 0; i <= needs.size(); i++){
                    cur.set(i,cur.get(i) - l.get(i));
                }
        }
            }

        if (!f){
            int max = cur.get(price.size());
            for (int i = 0; i < needs.size(); i++){
                max += (needs.get(i) - cur.get(i))* price.get(i);

            }
            if (max < sum){
                sum = max;
            }
        }
    }

    public static void main(String[] args) {

    }
}
