package com.algo0226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RecursiveTest {
    static int N, R, res[], input[];
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        input = new int[N];
        res = new int[R];
        visited = new boolean[N];
        stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(stk.nextToken());
        }
        System.out.println("순열===================");
        makePermutation(0);
        System.out.println("조합===================");
        makeCombination(0, 0);
        System.out.println("부분집합================");
        makeSubset(0);
    }
    static void makePermutation(int cnt){
        if(cnt == R){
            for(int i=0; i<R; i++){
                System.out.print(res[i]);
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            res[cnt] = input[i];
            makePermutation(cnt+1);
            visited[i] = false;
        }
    }
    static void makeCombination(int cnt, int start){
        if(cnt == R){
            for(int i=0; i<R; i++){
                System.out.print(res[i]);
            }
            System.out.println();
            return;
        }
        for(int i=start; i<N; i++){
            res[cnt] = input[i];
            makeCombination(cnt+1, i+1);
        }
    }
    static void makeSubset(int cnt){
        if(cnt == N){
            for(int i=0; i<N; i++){
                if(visited[i] == true){
                    System.out.print(input[i]);
                }
            }
            System.out.println();
            return;
        }
        visited[cnt] = true;
        makeSubset(cnt+1);
        visited[cnt] = false;
        makeSubset(cnt+1);
    }
}