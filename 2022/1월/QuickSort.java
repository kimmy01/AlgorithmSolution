package com.algo2022_01;

import java.util.Arrays;

public class QuickSort {
    static int[] arr = {1, 7, 4, 3, 5, 2, 6};
    public static void main(String[] args) {
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr, int start, int end){
        if(start >= end) return; //남은 원소 한 개일 때 종료
        int pivot = start; //피벗은 첫번째 원소
        int left = start+1;
        int right = end;
        while(left<=right){
            while(left <= end && arr[left] <= arr[pivot]){ //피벗보다 큰 데이터 찾을 때까지 반복
                left += 1;
            }
            while(right > start && arr[right] >= arr[pivot]){ //피벗보다 작은 데이터 찾을 때까지 반복
                right-=1;
            }
            if(left > right){ //엇갈린 경우 (피벗보다 작은 값과 피벗 자리 바꿈)
                int tmp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = tmp;
            }else{ //엇갈리지 않은 경우 (left, right 위치 값끼리 바꿈)
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
            quickSort(arr, start, right-1); //왼쪽 탐색
            quickSort(arr, right+1, end); //오른쪽 탐색
        }
    }
}
