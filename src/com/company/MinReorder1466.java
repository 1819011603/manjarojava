package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class MinReorder1466 {

    int ans = 0;

    boolean[] visited;
    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n];
        visited[0] = true;
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < connections.length; i++){
                dfs(i,connections);
        }

        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        for (int i = 0; i < connections.length; i++){
            dfs(i,connections);
        }

        for (int i = 0; i < connections.length; i++){
            if(visited[connections[i][0]] && !visited[connections[i][1]]){
                ans++;
            }
        }
        System.out.println(Arrays.toString(visited));
        return ans;
    }

    public void dfs(int pre,int[][] connections){

        if(pre < 0 ||pre >= connections.length ||(visited[connections[pre][0]] && visited[connections[pre][1]]))return;

        if(!visited[connections[pre][0]] && visited[connections[pre][1]]){
            visited[connections[pre][0]] = true;
            dfs(connections[pre][0],connections);

        }

       else if(!visited[connections[pre][1]] && visited[connections[pre][0]] ){
            visited[connections[pre][1]] = true;
            ans++;
            dfs(connections[pre][1],connections);

        }

    }

    public static void main(String[] args) {
        // 投机取巧 说实话我不知道它能过
//        System.out.println(new MinReorder1466().minReorder(5,new int[][]{{1,0},{1,2},{3,2},{3,4}}));
//        System.out.println(new MinReorder1466().minReorder(6,new int[][]{{0,1},{1,3},{2,3},{0,4},{4,5}}));
        System.out.println(new MinReorder1466().minReorder(6,new int[][]{{0,2},{0,3},{4,1},{4,5},{5,0}}));
//        System.out.println(new MinReorder1466().minReorder(5,new int[][]{{4,3},{2,3},{1,2},{1,0}}));
    }
}
