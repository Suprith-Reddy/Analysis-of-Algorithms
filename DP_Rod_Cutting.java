package com.suprithgurudu;

public class DP_Rod_Cutting {
    static int cutRod(int[] arr, int size, int c){
        int[] val = new int[size+1];
        val[0] = 0;
        int[] cuts = new int[size];
        int k = 0;
        for(int i=1;i<=size;i++){
            int max_val = Integer.MIN_VALUE;

            for(int j=0; j<i; j++){
                if(j == i-1){
                    if(max_val < arr[j]+val[i-j-1]){
                        max_val = arr[j]+val[i-j-1];
                        cuts[k] = -1;
                    }
                }
                else {
                    if (max_val < arr[j] + val[i - j - 1] - c) {
                        max_val = arr[j] + val[i - j - 1] - c;
                        cuts[k] = size-i-1;
                    }
                }
            }
            k++;
            val[i] = max_val;
        }
        for (int ele: cuts
             ) {
            System.out.println(ele);
        }

        return  val[size];
    }
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        int c = 2; //Cost of one cut
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size, c));
    }
}


