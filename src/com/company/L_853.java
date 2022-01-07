package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class L_853 {
    static class Pair{
        int p;
        int s;
        Pair(int a,int b){
            p = a;
            s = b;
        }
        Pair(){
            p = 0;
            s = 0;
        }

        public void setP(int p) {
            this.p = p;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getP() {
            return p;
        }

        public int getS() {
            return s;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] p = new Pair[position.length];
        for(int i = 0; i < position.length; i++){
            p[i].setP(position[i]);
            p[i].setS(speed[i]);
        }
        Arrays.sort(p, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o2.getP(),o1.getP());
            }
        });
        Deque<Double> stack = new LinkedList<>();
        for(int i = 0; i < position.length; i++){
           double d = (target-p[i].getP())/(double)p[i].getS();
           if(stack.size() == 0|| stack.peekLast() < d){
               stack.addLast(d);
           }

        }
        return stack.size();

    }

}
