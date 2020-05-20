package com.suprithgurudu;

public class MergeSort {
    public static void main(String[] args){
        int[] input = {1,3,2,6,4,9,5,10,8,7};
        if(input.length == 0){
            System.out.print("No elements to sort");
            return;
        }
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
        int[] output = split(input, 0, input.length-1);
        for(int i=0;i<output.length;i++){
            System.out.print(output[i]+" ");
        }
    }
    private static int[] split(int[] input, int low, int high){
        if(low == high){
            int[] sortedArr = {input[low]};
            return sortedArr;
        }
        int mid = (low + high) / 2;
        int[] leftSorted = split(input, low, mid);
        int[] rightSorted = split(input, mid + 1, high);
        return combine(leftSorted, rightSorted);
    }
    private static int[] combine(int[] leftSorted, int[] rightSorted){
        int leftLen = leftSorted.length;
        int rightLen = rightSorted.length;
        int[] sorted = new int[leftLen+rightLen];

        int i=0, j=0, k=0;
        while(i<=leftLen-1&&j<=rightLen-1){
            if(leftSorted[i]<rightSorted[j]){
                sorted[k] = leftSorted[i];
                i++;
            }
            else{
                sorted[k] = rightSorted[j];
                j++;
            }
            k++;
        }
        while(i<=leftLen-1){
            sorted[k] = leftSorted[i];
            i++;
            k++;
        }
        while(j<=rightLen-1){
            sorted[k] = rightSorted[j];
            j++;
            k++;
        }

        return sorted;
    }
}
