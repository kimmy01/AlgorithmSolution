package com.algo2022_01;

import java.util.Arrays;

public class BubbleSort1 {
    static int[] array = {5, 3, 1, 2, 4, 6, 7, 10, 9, 8};
    public static void main(String[] args) {
        for(int i=array.length-1; i>=0; i--){
            for(int j=0, k=j+1; j<i; j++, k++){
                if(array[j] > array[k]){
                    int tmp = array[j];
                    array[j] = array[k];
                    array[k] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
