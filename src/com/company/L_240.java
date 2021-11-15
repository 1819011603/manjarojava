package com.company;

public class L_240 {
    boolean ans = false;
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);

    }




    public boolean binarySearch(int[][] matrix,int x1, int y1,int x2,int y2,int target){
        if(x1 > x2 || y1 > y2|| ans)return false;
        int a = x1,b = y1,c = x2,d = y2;
        int mid1,mid2;
        if (x2-x1 < y2 -y1){
            y2 = y1 + (x2-x1);
        }else x2 = x1 + (y2-y1);
        while (x1 <= x2 && y1 <=y2 ){
            mid1 = (x1 +x2) /2;
            mid2 = (y1 + y2)/2;
            if (matrix[mid1][mid2] < target){
                x1 = mid1+1;
                y1 = mid2+1;
            }else if (matrix[mid1][mid2] > target){
                x2 = mid1-1;
                y2 = mid2-1;
            }else {
                ans= true;
                return true;
            }
        }
        if (binarySearch(matrix,a,y1,x1-1,d,target))return true;
        if (ans ||binarySearch(matrix,x1,b,c,y1-1,target))return true;
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 31; i++){
            System.out.println("i: " + i);
            System.out.println(new L_240().searchMatrix(new int[][]{
                    new int[]{1,4,7,11,15},
                    new int[]{2,5,8,12,19},
                    new int[]{3,6,9,16,22},
                    new int[]{10,13,14,17,24},
                    new int[]{18,21,23,26,30},
            },i));
            System.out.println();
        }

    }
}
