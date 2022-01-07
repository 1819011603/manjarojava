package com.company;

import java.util.Arrays;
import java.util.TreeSet;

public class L_715 {
    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(6,8);
        rangeModule.removeRange(7,8);
        rangeModule.removeRange(8,9);
        rangeModule.addRange(8,9);
        rangeModule.removeRange(1,3);
        rangeModule.addRange(1,8);
        System.out.println(rangeModule.queryRange(2,4));
        System.out.println(rangeModule.queryRange(2,9));
        System.out.println(rangeModule.queryRange(4,6));
    }
}

class RangeModule {
    static class Interval implements Comparable<Interval>{
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public Interval() {
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }


        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.getLeft(),o.left);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Interval interval = (Interval) o;

            if (left != interval.left) return false;
            return right == interval.right;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    TreeSet<Interval> set;
    public RangeModule() {
        set = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Interval add = new Interval(left,right);
        Interval min = set.floor(add);
        if (add.equals(min))return;
        Interval max = set.ceiling(new Interval(left+1,right));
        if (min == null){
            set.add(add);
        }else{
            if(min.getRight() > add.getRight()){
            }else if(min.getRight() < add.getLeft()){
                set.add(add);
            }else {
                min.setRight(add.getRight());
            }
        }

        while (max != null && max.getLeft() <= add.getRight()){
            set.remove(max);
            addRange(max.getLeft(),max.getRight());
            max = set.ceiling(new Interval(left+1,right));
        }

    }

    public boolean queryRange(int left, int right) {
        Interval query = new Interval(left,right);
        Interval find = set.floor(query);

        return find != null && find.getRight()>= query.getRight();
    }

    public void removeRange(int left, int right) {
        System.out.println(set);
        Interval remove = new Interval(left,right);
        Interval min = set.floor(remove);
        if (remove.equals(min)){
            set.remove(remove);
            return;
        }
        Interval max = set.ceiling(new Interval(left+1,right));
        if (min!= null){
            if (min.getRight() > remove.getRight()){

                remove.setRight(min.getRight());
                min.setRight(remove.getLeft());
                remove.setLeft(right);
                set.add(remove);
            }else if(min.getRight() <= remove.getLeft()){
                return;
            }else {
                if (min.getLeft() != remove.getLeft())
                min.setRight(remove.getLeft());
                else {
                    set.remove(min);
                }
            }
        }
        while (max != null && max.getLeft() < right){
            if (max.getLeft() != left){
                if (max.getRight() <= right){
                    set.remove(max);
                }else
                max.setLeft(right);
            }else {
                if (max.getRight() <= right){
                    set.remove(max);
                }else
                    max.setLeft(right);
            }
            max = set.ceiling(new Interval(left+1,right));
        }

        System.out.println(left + " " + right);
        System.out.println(set);
  

    }
}
