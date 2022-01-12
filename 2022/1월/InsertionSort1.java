package com.algo2022_01;

import java.util.Arrays;

public class InsertionSort1 {
    static int[] array = {5, 3, 1, 2, 4, 6, 7, 10, 9, 8};
    public static void main(String[] args) {
        for(int i=1; i<array.length; i++){
            int checkNum = array[i];
            int checkIdx = i;
            for(int j=i; j>=0; j--){
                if(checkNum < array[j]){
                    int tmp = array[j];
                    array[j] = array[checkIdx];
                    array[checkIdx] = tmp;
                    checkIdx = j;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
