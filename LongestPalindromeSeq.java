package com.suprithgurudu;

public class LongestPalindromeSeq {
    public static int LongPalindromeSeq(String seq){
        int end = seq.length();
        int[][] res = new int[end][end];
        for(int i=0;i<end;i++)
            res[i][i] = 1;
        int j;
        for(int d=2;d<=end;d++){
            for(int i=0;i<end-d+1;i++){
                j = i+d-1;
                if(seq.charAt(i) == seq.charAt(j)){
                    if(d!=2)
                        res[i][j] = res[i+1][j-1] + 2;
                    else
                        res[i][j] = 2;
                }
                else
                    res[i][j] = Math.max(res[i+1][j], res[i][j-1]);
            }
        }
        return res[0][end-1];
    }
    public static void main(String[] args){
        String seq = "BABCBAB";
        System.out.println(LongPalindromeSeq(seq));
    }
}
