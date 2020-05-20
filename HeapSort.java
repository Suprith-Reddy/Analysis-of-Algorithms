package com.suprithgurudu;

public class HeapSort {
    public static void main(String[] args){
        int[] input = {4,2,5,6,1,8,3,7,11,10};
        int[] output = heapSort(input);
        for(int i=0;i<output.length;i++){
            System.out.print(output[i]+" ");
        }
    }
    private static int leftChild(int i){
        return (2 * i) + 1;
    }
    private static int rightChild(int i) {
        return (2 * i) + 2;
    }
    private static int[] buildMaxHeap(int[] input, int len){
        int[] tempOutput = heapify(input, len);
        //Swap first and last elements
        tempOutput[0] += tempOutput[len];
        tempOutput[len] = tempOutput[0] - tempOutput[len];
        tempOutput[0] -= tempOutput[len];
        return tempOutput;
    }
    private static int[] heapify(int[] input, int len){
        int idx = len/2;
        while(idx>=0){
            int tempIdx = heapifyHelper(input, idx, len);

            int swapIdx = idx;
            while(input[tempIdx] > input[swapIdx]){
                input[swapIdx] += input[tempIdx];
                input[tempIdx] = input[swapIdx] - input[tempIdx];
                input[swapIdx] -= input[tempIdx];
                swapIdx = tempIdx;
                tempIdx = heapifyHelper(input, tempIdx, len);
            }
            idx--;
        }
        return input;
    }
    private static int heapifyHelper(int[] input, int idx, int len){
        int tempIdx = idx;
        if(rightChild(idx)<=len && leftChild(idx)<=len){
            if(input[leftChild(idx)] < input[rightChild(idx)]){
                tempIdx = rightChild(idx);
            }
            else{
                tempIdx = leftChild(idx);
            }
        }
        else if(leftChild(idx)<=len){
            tempIdx = leftChild(idx);
        }
        return tempIdx;
    }
    private static int[] heapSort(int[] input){
        int[] output = new int[input.length];
        for(int len = input.length-1; len>0; len--){
            output = buildMaxHeap(input, len);
        }
        return output;
    }
}
