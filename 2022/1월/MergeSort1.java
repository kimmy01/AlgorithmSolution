package com.algo2022_01;

import java.util.Arrays;

public class MergeSort1 {
    static int[] tmp = new int[10];
    static int[] array = {5, 3, 1, 2, 4, 6, 7, 10, 9, 8};
    public static void main(String[] args) {
        mergeSort(0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
    static void mergeSort(int start, int end){
        if(start < end){
            int mid = (start+end)/2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            int p = start;
            int q = mid+1;
            int idx = p;

            while(p <= mid || q <= end){
                if(q > end || (p <= mid && array[p] < array[q])){ //두번째 배열 다 넣었거나 첫번째 배열 값이 더 작을 때
                    tmp[idx++] = array[p++];
                }else{
                    tmp[idx++] = array[q++];
                }
            }

            for(int i=start; i<=end; i++){
                array[i] = tmp[i];
            }
        }
    }
}
