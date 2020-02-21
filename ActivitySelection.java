package com.suprithgurudu;

public class ActivitySelection {
    public static int[] activities(int[] start, int[] finish){
        int[] res = new int[start.length];
        for(int j=0; j<res.length; j++){
            res[j] = -1;
        }

        if(start == null || finish == null)
            return null;
        int i = 0;
        res[i++] = 0;
        int f_idx = 0;
        for(int k=1; k<start.length; k++){
            if(finish[f_idx] <= start[k]){
                res[i++] = k;
                f_idx++;
            }
        }

        return res;
    }
    public static void main(String[] args){
        int[] start = {1,3,0,5,8,5};
        int[] finish = {2,4,6,7,9,9};

        //int[] res = new int[start.length];
        int[] res = activities(start, finish);
        for(int ele: res){
            if(ele != -1)
                System.out.println(ele);
        }
    }
}
