package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        double[][] grid = new double[20][20];
        for (int i = 0; i < 20; i++){
            Arrays.fill(grid[i],-1.0);
        }
        Integer x,y;
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        List<String> p;
        boolean lx,ly;
        for (int j = 0;j < n; j++){
            lx = ly = false;
            p = equations.get(j);
            if (!map.containsKey(p.get(0))){
                x = i;
                grid[x][x] = 1;
                map.put(p.get(0),i++);
            }else {
                x = map.get(p.get(0));
                lx = true;
            }

            if (!map.containsKey(p.get(1))){
                y = i;
                grid[y][y] = 1;
                map.put(p.get(1),i++);
            }else {
                y = map.get(p.get(1));
                ly = true;
            }

            grid[x][y] = values[j];
            grid[y][x] = 1/values[j];
            if (ly){
                for (int b = 0; b< i; b++){
                    if (grid[y][b] != -1 && grid[x][b] == -1){
                        grid[x][b] = grid[x][y] * grid[y][b];
                        grid[b][x] = 1/grid[x][b];
                    }

                }
                if (lx){
                    for (int b = 0; b< i; b++){
                        if (grid[x][b] != -1 && grid[y][b] == -1) {
                            grid[y][b] = grid[y][x] * grid[x][b];
                            grid[b][y] = 1/grid[y][b];
                        }

                    }
                }
            }else if (lx){
                for (int b = 0; b< i; b++){
                    if (grid[x][b] != -1 && grid[y][b] == -1) {
                        grid[y][b] = grid[y][x] * grid[x][b];
                        grid[b][y] = 1/grid[y][b];
                    }

                }
            }
        }
        n = i;
//        for (i = 0; i < n; i++){
//            for (int j = i+1; j < n; j++){
//                for (int k = 0; k < n; k++){
//                    if (grid[i][j]!= -1 || grid[i][k] == -1 || grid[k][j] == -1){
//                        continue;
//                    }
//                    grid[i][j] = grid[i][k] * grid[k][j];
//                    grid[j][i] = 1/grid[i][j];
//                }
//            }
//        }
        double[] ans = new double[queries.size()];
        i = 0;
        for (List<String> l: queries){
            x = map.get(l.get(0));
            y = map.get(l.get(1));
            if (x == null || y == null){
                ans[i++] = -1.0;
            }else {
                if (grid[x][y] == -1){
                    for (int t = 0; t < n; t++){
                        if (grid[x][t] != -1 && grid[t][y] != -1){
                            grid[x][y] = grid[x][t] * grid[t][y];
                            grid[y][x] = 1/ grid[x][y];
                        }
                    }
                }
                ans[i++] = grid[x][y];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<String>> eq = new ArrayList<>();

        List<String> a;
        a = new ArrayList<>();
        a.add("a");
        a.add("c");
        eq.add(a);

        a = new ArrayList<>();
        a.add("b");
        a.add("e");
        eq.add(a);
        a = new ArrayList<>();
        a.add("c");
        a.add("d");
        eq.add(a);
        a = new ArrayList<>();
        a.add("e");
        a.add("d");
        eq.add(a);

        double[] v=  new double[]{4,1,2,3};

        List<List<String>> qu = new ArrayList<>();
        a = new ArrayList<>();
        a.add("a");
        a.add("b");
        qu.add(a);


        System.out.println(Arrays.toString(new L_399().calcEquation(eq,v,qu)));
    }
}
