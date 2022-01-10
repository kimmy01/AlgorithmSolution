package com.algo2022_01;

import java.util.Arrays;

public class InsertionSort {
    static int[] arr = {1, 7, 4, 3, 5, 2, 6};
    public static void main(String[] args) {
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
