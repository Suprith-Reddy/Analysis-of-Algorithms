package com.suprithgurudu;

public class ActivitySelSortedStart {
    public static int[] activities(int[] start, int[] finish){
        int[] res = new int[start.length];
        for(int j=0; j<res.length; j++){
            res[j] = -1;
        }

        if(start == null || finish == null)
            return null;
        int i = 0;
        res[i++] = start.length - 1;
        int s_idx = start.length - 1;
        for(int k=start.length-2; k>=0; k--){
            if(start[s_idx] >= finish[k]){
                res[i++] = k;
                s_idx--;
            }
        }

        return res;
    }
    public static void main(String[] args){
        int[] start = {0,1,3,5,5,8};
        int[] finish = {6,2,4,7,9,9};

        //int[] res = new int[start.length];
        int[] res = activities(start, finish);
        for(int ele: res){
            if(ele != -1)
                System.out.println(ele);
        }
    }
}
