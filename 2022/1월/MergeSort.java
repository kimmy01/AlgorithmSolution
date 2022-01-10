package com.algo2022_01;

import java.util.Arrays;

public class MergeSort {
    static int[] tmp = new int[7];
    static int[] arr = {1, 7, 4, 3, 5, 2, 6};
    public static void main(String[] args) {
        mergeSort(0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int start, int end){
        if(start < end){
            int mid = (start+end)/2; //중간값
            mergeSort(start, mid); //반 나누기 {1, 7, 4, 3}
            mergeSort(mid+1, end); //반 나누기 {5, 2, 6}
            int p = start; //0 첫번째 배열 시작점
            int q = mid+1; //4 두번째 배열 시작점
            int idx = p; //인덱스는 첫번째 배열 시작점

            while(p <= mid || q <= end){ //범위 내에서 진행
                if(q > end || (p <= mid && arr[p] < arr[q])){ //두번째 배열에서 원소를 다 가져왔거나 || 첫번째 배열에서 아직 남은 원소가 있고 첫번째 배열의 원소값이 두번째 배열의 첫원소값보다 작으면
                    tmp[idx++] = arr[p++]; //첫번째 배열에서 가져와서 저장
                }else{
                    tmp[idx++] = arr[q++]; //두번째 배열에서 가져와서 저장
                }
            }

            for(int i=start; i<=end; i++){ //기존 배열로 다시 옮겨주기
                arr[i] = tmp[i];
            }
        }
    }
}
