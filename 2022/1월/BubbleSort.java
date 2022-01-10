package com.algo2022_01;

import java.util.Arrays;

public class BubbleSort {
    static int[] arr = {1, 7, 4, 3, 5, 2, 6};
    public static void main(String[] args) {
        for(int k=arr.length; k>=0; k--){
            for(int i=0, j=i+1; j<k; i++, j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
