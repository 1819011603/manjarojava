package com.company;

import java.util.Scanner;

public class GetPermutation60 {
    StringBuilder ans = new StringBuilder();
    int ss = 1;
    int u;
    public int getNP(int n){
        int ans = 1;
        for (int i = 2; i <= n; i++){
            ans *= i;
        }
        return ans;
    }
    public String getPermutation(int n,int k){
        boolean[] visited = new boolean[n+1];
        u = getNP(n);
        dfs(n,k,visited);
        return ans.toString();
    }

    public void dfs(int n, int k,boolean[] visited){
        if(k == 1){
            for (int i = 1; i < visited.length; i++){
                if(!visited[i]){
                    ans.append(i);
                }
            }
            return;
        }

        if(k == 0){
            int t = 0;
            int i;
            StringBuilder temp = new StringBuilder();
            for (i = visited.length-1; i >= 1; i--){
                if(!visited[i]){
                    ++t;
                    temp.append(i);
                    if(t ==ss ){
                        break;
                    }
                }
            }
            for (int j = 1; j < i; j++){
                if(!visited[j]){
                    ans.append(j);
                }
            }
            ans.append(temp);


            return;
        }

        u = u / n;
        int c = k / u;
        if(k % u!= 0){
            c++;
        }else {
            ss = n-1;
        }
        int i,time = 0;

        for (i = 1; i < visited.length; i++){
            if(!visited[i]){
                if(++time == c)break;
            }
        }
        visited[i] = true;
        ans.append(i);
        dfs(n-1,k % u,visited);


    }

    public static void main(String[] args) {

        System.out.println(new GetPermutation60().getPermutation(9,241327));


    }
}
