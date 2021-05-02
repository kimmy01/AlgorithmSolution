package com.algo0502;
import java.io.*;
import java.util.*;
public class Main_BOJ_5567_결혼식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] friends = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 1){
                q.add(b);
                visited[b] = true;
            }else if(b == 1) {
                q.add(a);
                visited[a] = true;
            }
            friends[a][b] = 1;
            friends[b][a] = 1;
        }
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=2; i<=N; i++){
                if(friends[tmp][i] == 1){
                    visited[i] = true;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<N+1; i++){
            if(visited[i]) answer++;
        }
        System.out.println(answer);
    }
}
