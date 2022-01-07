package com.company;

public class L_464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean[] vis = new boolean[maxChoosableInteger+1];
        return dfs(vis,0,desiredTotal,1);
    }

    public boolean dfs(boolean[] vis,int sum, int desiredTotal,int time){
        if(time % 2 == 1){
            for(int i = 1; i < vis.length; i++){
                if(!vis[i]){
                    if(sum + i >= desiredTotal){
                        return true;
                    }

                }
            }
            for(int i = 1; i < vis.length; i++){
                if(!vis[i]){
                    vis[i] = true;
                    if(dfs(vis,sum+i,desiredTotal,time+1)){
                        vis[i] = false;
                        return true;
                    }else vis[i] = false;
                }
            }
            return false;
        }else{
            for(int i = 1; i < vis.length; i++){
                if(!vis[i]){

                    if(sum + i >= desiredTotal){
                        return false;
                    }

                }
            }

            for(int i = 1; i < vis.length; i++){
                if(!vis[i]){
                    vis[i] = true;
                    if(!dfs(vis,sum+i,desiredTotal,time+1)){
                        vis[i] = false;
                        return false;
                    }else vis[i] = false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new L_464().canIWin(10,40));
    }
}
