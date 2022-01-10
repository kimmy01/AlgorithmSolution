package com.algo2022_01;

import java.util.Arrays;

public class SelectionSort {
    static int[] arr = {1, 7, 4, 3, 5, 2, 6};
    public static void main(String[] args) {
        for(int i=0; i<arr.length; i++){
            int min = 10;
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    if(min > arr[j]){
                        min = arr[j];
                        minIdx = j;
                    }
                }
            }
            if(minIdx == i) continue;
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
