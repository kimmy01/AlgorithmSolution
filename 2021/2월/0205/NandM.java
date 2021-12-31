package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        StringTokenizer stk = new StringTokenizer(in, " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];
        int[] output = new int[M];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++){
            visited[i] = false;
        }

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        perm(arr, output, visited, 0, N, M);
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int N, int M){
        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }



        for(int i=0; i<N; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth+1, N, M);
                visited[i] = false;
            }
        }
    }

}
