package com.algo0307;
import java.util.*;
import java.io.*;
public class Main_BOJ_2606_바이러스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N+1][N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        for(int i=0; i<K; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }
        boolean[] pc = new boolean[N+1];
        while(!queue.isEmpty()){
            int temp = queue.poll();
            pc[temp] = true;
            for(int i=0; i<N+1; i++){
                if(arr[temp][i] == true && pc[i]==false){
                    queue.offer(i);
                }
            }
        }
        int count = 0;
        for(int i=0; i<N+1; i++){
            if(pc[i] == true){
                count++;
            }
        }
        System.out.println(count-1);
    }
}
