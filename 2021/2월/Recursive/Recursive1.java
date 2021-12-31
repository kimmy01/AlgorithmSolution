package com.recursive;

import java.util.Arrays;

public class Recursive1 {
    static int sum;
    static int mul;
    public static void main(String[] args) {
        //1번) main메소드내에서 0부터 4까지 출력하시오. (for문 사용)
        for(int i=0; i<=4; i++){
            System.out.println(i);
        }
        //2번) main메소드내에서 0부터 4까지 출력하시오. (while문 사용)
        int n=0;
        while(n<5){
            System.out.println(n);
            n++;
        }
        //3번) main메소드내에서 recursive()메소드를 호출하여 0부터 4까지 출력하시오.
        recursive(0);
        //4번) main메소드내에 선언 초기화된 배열의 값을 recursive()메소드에서 출력하시오.
        int[] arr = {1, 3, 5, 7, 9};
        recursive2(arr,0);
        //5번) main메소드내에 선언 초기화된 배열의 값에 대해 recursive()메소드에서 배열 총합계를 출력하시오.
        sum = 0;
        recursive3(arr, 0);
        //6번) main메소드내에 선언 초기화된 배열의 값에 대해 recursive()메소드에서 배열의 데이터를 다 곱한 값을 출력하시오.
        mul = 1;
        recursive4(arr, 0);
        //7번) main메소드내에 선언 초기화된 배열의 값에 대해 permutation()메소드에서 순열을 구하시오.
        int[] arr2 = {1, 3, 5};
        int[] res = new int[arr2.length];
        permuation(arr2, res, 0, new boolean[arr.length]);
        //8번) main메소드내에 선언 초기화된 배열의 값에 대해 combination()메소드에서 조합을 구하시오.
        int[] res2 = new int[2];
        combination(arr2, res2, 0, 0);
        //9번) main메소드내에 선언 초기화된 배열의 값에 대해 powerset()메소드에서 부분집합을 구하시오.
        powerset(arr2, 0, 0, new boolean[arr2.length]);
    }
    static void recursive(int n){
        if(n==5) return;
        System.out.println(n);
        recursive(n+1);
    }
    static void recursive2(int[]arr, int n){
        if(n==5) return;
        System.out.println(arr[n]);
        recursive2(arr,n+1);
    }
    static void recursive3(int[] arr, int n){
        if(n==5) {System.out.println(sum);return;}
        sum+=arr[n];
        recursive3(arr, n+1);
    }
    static void recursive4(int[] arr, int n){
        if(n==5) {System.out.println(mul);return;}
        mul*=arr[n];
        recursive4(arr, n+1);
    }
    static int cnt;
    static void permuation(int[] arr2, int[] res, int n, boolean[] visited){
        if(n==res.length){
            System.out.println(Arrays.toString(res));
            return;
        }
        for(int i=0; i<arr2.length; i++){
            if(!visited[i]){
                visited[i]=true;
                res[n]=arr2[i];
                permuation(arr2, res, n+1, visited);
                visited[i]=false;
            }
        }
    }
    static void combination(int[] arr2, int[] sel, int n, int k){
        if(k == sel.length){
            System.out.println(Arrays.toString(sel));
            return;
        }
        if(n == arr2.length){
            return;
        }
        sel[k]=arr2[n];
        combination(arr2, sel, n+1, k+1);
        combination(arr2, sel, n+1, k);
    }
    static void powerset(int[] arr2, int n, int cnt, boolean[] sel){
        if(n==arr2.length){
            System.out.print("[ ");
                for(int i=0; i<arr2.length; i++){
                    if(sel[i]){
                        System.out.print(arr2[i]+" ");
                    }
                }
            System.out.print("] ");
            return;
        }
        sel[n]=true;
        powerset(arr2, n+1, cnt+1, sel);
        sel[n]=false;
        powerset(arr2, n+1, cnt, sel);
    }
}
