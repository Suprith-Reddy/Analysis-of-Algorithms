package com.suprithgurudu;

public class MinOfCoins {

    public static int[] minCoins(int[] denoms, int V){
        int res[] = new int[denoms.length];
        for(int j=0; j<res.length; j++){
            res[j] = -1;
        }
        int p = 0;
        for(int i = denoms.length-1; i>=0; i--){
            while(denoms[i] <= V){
                V -= denoms[i];
                res[p++] = denoms[i];
            }
            if(V == 0)
                break;
        }

        return res;
    }
    public static void main(String[] args){
        int[] denoms = {1,2,5,10,20,50,100,500,1000};
        int Value = 93;

        int[] res = minCoins(denoms, Value);
        for(int ele: res){
            if(ele != -1)
                System.out.println(ele);
        }
    }
}
