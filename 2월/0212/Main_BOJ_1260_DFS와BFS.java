package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS {
    static int[][] check; //간선 연결
    static boolean[] checked; //확인 여부
    static int N;
    static int M;
     static int V;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer stk = new StringTokenizer(str, " ");
        N = Integer.parseInt(stk.nextToken()); //정점 개수
        M = Integer.parseInt(stk.nextToken()); //간선 개수
        V = Integer.parseInt(stk.nextToken());
        check = new int[1001][1001];
        checked = new boolean[1001];

        for(int i=0; i<M; i++){
            str = br.readLine();
            stk = new StringTokenizer(str, " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            check[x][y] = 1;
            check[y][x] = 1;
        }
        dfs(V);
        checked = new boolean[1001];
        System.out.println();
        bfs();
    }

    static void dfs(int i){
        checked[i] = true;
        System.out.print(i+" ");
        for(int j=1; j<=N; j++){
            if(check[i][j] == 1 && checked[j] == false){ //
                dfs(j);
            }
        }
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V);
        checked[V] = true;
        System.out.print(V+" ");

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int j=1; j<=N; j++){
                if(check[temp][j] == 1 && checked[j] == false){
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j+" ");
                }
            }
        }
    }
}
