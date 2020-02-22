package com.suprithgurudu;

import java.util.ArrayList;

public class ZeroOneKnapsack {
    public static int knapsack01(int[] W, int[] V, int cap){
        ArrayList<Integer> weights = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        //Excluding items with weights more than capacity of knapsack
        for(int i=0;i<W.length; i++){
            if(W[i]<=cap){
                weights.add(W[i]);
                values.add(V[i]);
            }
        }

        int n = weights.size();
        int CP = cap;
        int[][] result = new int[n+1][CP+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<cap+1; j++){
                if(i==0 || j==0)
                    result[i][j] = 0;
                else if(weights.get(i-1) <= j){
                    result[i][j] = Math.max(result[i-1][j], result[i-1][j-weights.get(i-1)]+values.get(i-1));
                }
                else {
                    result[i][j] = result[i-1][j];
                }
            }
        }

        return result[n][CP]; //O(nW) / O(n*CP)
    }
    public static void main(String[] args){
        int[] W = {10,20,30,60};
        int[] V = {60,100,120,200};
        int capacity = 50;

        System.out.println(knapsack01(W,V,capacity));
    }
}
