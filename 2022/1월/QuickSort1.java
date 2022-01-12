package com.algo2022_01;

import java.util.Arrays;

public class QuickSort1 {
    static int[] array = {5, 3, 1, 2, 4, 6, 7, 10, 9, 8};
    public static void main(String[] args) {
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
    static void quickSort(int[] array, int start, int end){
        if(start >= end) return;
        int pivot = start;
        int left = start+1;
        int right = end;
        while(left<=right){
            while(left<=end && array[left]<=array[pivot]){
                left++;
            }
            while(right>start && array[right]>=array[pivot]){
                right--;
            }
            if(left>right){
                int tmp = array[right];
                array[right] = array[pivot];
                array[pivot] = tmp;
            }else{
                int tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
            }
            quickSort(array, start, right-1);
            quickSort(array, right+1, end);
        }
    }
}
