package com.algo0323;
import java.util.*;
import java.io.*;
public class Main_BOJ_4485_녹색옷을입은애가젤다지 {
    private static class Node implements Comparable<Node>{
        int row;
        int col;
        int weight;
        public Node(int row, int col, int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        while(true){
            cnt++;
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];
            cost = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println("Problem "+cnt+": "+func());
        }
    }
    static int func(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        cost[0][0] = map[0][0];
        pq.offer(new Node(0, 0, map[0][0]));
        while(!pq.isEmpty()){
            Node current = pq.poll();
            for(int i=0; i<4; i++){
                int nr = current.row+dr[i];
                int nc = current.col+dc[i];
                if(inRange(nr, nc)){
                    if(cost[nr][nc] > cost[current.row][current.col]+map[nr][nc]){
                        cost[nr][nc] = cost[current.row][current.col]+map[nr][nc];
                        pq.offer(new Node(nr, nc, cost[nr][nc]));
                    }
                }
            }
        }
        return cost[N-1][N-1];
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<N){
            return true;
        }
        return false;
    }
}