package com.suprithgurudu;

public class EditDistance {
    public static int editDist(char[] str1, char[] str2){
        int m = str1.length;
        int n = str2.length;
        int[][] C = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)
                    C[i][j] = 0;
                else{
                    if(str1[i-1] == str2[j-1]){
                        C[i][j] = C[i-1][j-1] + 1;
                    }
                    else{
                        C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
                    }
                }
            }
        }
        return str2.length - C[m][n]; //O(m*n)
    }
    public static void main(String[] args){
        char[] str1 = {'g','e','e','k'};
        char[] str2 = {'g','e','s','e','k'};

        char[] str3 = "sunday".toCharArray();
        char[] str4 = "saturday".toCharArray();

        System.out.println(editDist(str3, str4));
    }
}
