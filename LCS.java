package com.suprithgurudu;

public class LCS {
    public static int lcs(int m, int n, char[] A, char[] B){

        int[][] R = new int[m+1][n+1];
        char[][] path = new char[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)
                    R[i][j] = 0;
                else if(A[i-1] == B[j-1]){
                    R[i][j] = R[i-1][j-1] + 1;
                    path[i][j] = 'd';
                }
                else{
                    if(R[i-1][j]>R[i][j-1]){
                        R[i][j] = R[i-1][j];
                        path[i][j] = 'l';
                    }
                    else{
                        R[i][j] = R[i][j-1];
                        path[i][j] = 'r';
                    }
                }
            }
        }
        int i = m;
        int j = n;
        while(i>0 && j>0){
            if(A[i-1] == B[j-1])
                System.out.println(A[i-1]);
            if(path[i][j] == 'd'){
                i--;
                j--;
            }
            else if(path[i][j] == 'l'){
                i--;
            }
            else{
                j--;
            }
        }
        return R[m][n];
    }
    public static void main(String[] args){
        char[] A = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] B = {'B', 'D', 'C', 'A', 'B', 'A'};

        int result = lcs(A.length,B.length, A, B);
        System.out.println(result);
    }
}
