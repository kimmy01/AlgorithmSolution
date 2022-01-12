package com.algo2022_01;

import java.util.Arrays;

public class SelectionSort1 {
    static int[] array = {5, 3, 1, 2, 6, 7, 10, 9, 8};
    public static void main(String[] args) {
        for(int j=0; j<array.length; j++){
            int min = 1234;
            int minIdx = 0;
            for(int i=j+1; i<array.length; i++){
                if(array[j] > array[i]){
                    if(min > array[i]){
                        min = array[i];
                        minIdx = i;
                    }
                }
            }
            if(minIdx == 0) continue;
            int tmp = array[j];
            array[j] = array[minIdx];
            array[minIdx] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }
}
