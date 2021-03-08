package com.algo0308;
import java.util.*;
import java.io.*;
public class Main_BOJ_1717_집합의표현 {
    static int arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        arr = new int[N+1];
        for(int i=0; i<N+1; i++){
            arr[i] = i;
        }
        for(int i=0; i<M; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if(command == 0){
                Union(a, b);
            }else{
                if(getParent(a) == getParent(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
    static int getParent(int n){
        if(n == arr[n])
            return n;
        return arr[n] = getParent(arr[n]);
    }
    static void Union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a != b){
            arr[b] = a;
        }
    }
}
