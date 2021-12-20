package com.algo12;

public class CombinationPractice {
    static int N = 3;
    static int[] arr = {1, 2, 3, 4, 5};
    public static void main(String[] args) {
        System.out.println("======순열=====");
        perm(new int[N],0, new boolean[arr.length]);
        System.out.println("======조합=====");
        comb(new int[N], 0, 0);
        System.out.println("======부분집합=====");
        powerset(0, new boolean[arr.length]);
        System.out.println("======중복순열=====");
        repeatPerm(new int[N], 0);
        System.out.println("======중복조합=====");
        repeatComb(new int[N], 0, 0);
    }
    static void perm(int[] result, int depth, boolean[] visited){ //순서있게 중복없이
        if(depth == N) {
            print(result);
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                perm(result,depth+1, visited);
                visited[i] = false;
            }
        }
    }
    static void comb(int[] result, int depth, int start){ //순서없이 중복없이
        if(depth == N){
            print(result);
            return;
        }
        for(int i=start; i<arr.length; i++){
            result[depth] = arr[i];
            comb(result, depth+1, i+1);
        }
    }
    static void powerset(int index, boolean[] selected){ //부분집합
        if(index == arr.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<selected.length; i++){
                if(selected[i]){
                    sb.append(arr[i]+ " ");
                }
            }
            System.out.println(sb.toString());
            return;
        }
        selected[index] = true;
        powerset(index+1, selected);
        selected[index] = false;
        powerset(index+1, selected);
    }
    static void repeatPerm(int[] result, int depth){ //순서있게 중복있게
        if(depth == N){
            print(result);
            return;
        }
        for(int i=0; i<arr.length; i++){
            result[depth] = arr[i];
            repeatPerm(result, depth+1);
            result[depth] = 0;
        }
    }
    static void repeatComb(int[] result, int depth, int start){ //순서없게 중복있게
        if(depth == N){
            print(result);
            return;
        }
        for(int i=start; i<arr.length; i++){
            result[depth] = arr[i];
            repeatComb(result, depth+1, i);
            result[depth] = 0;
        }
    }
    static void print(int[] result){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
