package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main16236 {
    static int N, sharkR, sharkC, sharkSize, time, eatCnt;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static Queue<int[]> find() {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] < sharkSize && map[i][j] > 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        return queue;
    }
    static void func() {
        while(true){
            Queue<int[]> queue = find();
            if(queue.size() == 0) break;
            int[][] distance = new int[N][N];
            int min = 123456789;
            distance[sharkR][sharkC] = 9;
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                int dis = bfs(now[0], now[1]);
                distance[now[0]][now[1]] = dis;
                if(dis == 0) continue;
                min = Math.min(dis, min);
            }
            if(min == 123456789) break;
            loop: for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(distance[i][j] == min){
                        time+=distance[i][j];
                        map[i][j] = 0;
                        sharkR = i;
                        sharkC = j;
                        eatCnt++;
                        if(eatCnt == sharkSize){
                            sharkSize++;
                            eatCnt = 0;
                        }
                        break loop;
                    }
                }
            }
        }
        System.out.println(time);
    }
    static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sharkR, sharkC});
        boolean[][] visited = new boolean[N][N];
        visited[sharkR][sharkC] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] now = q.poll();
                if(now[0] == r && now[1] == c) return time;
                for(int j=0; j<4; j++){
                    int nr = now[0]+dr[j];
                    int nc = now[1]+dc[j];
                    if(inRange(nr, nc) && !visited[nr][nc] && map[nr][nc]<=sharkSize){
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            if(q.isEmpty()) break;
            time++;
        }
        return 0;
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<N) return true;
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sharkSize = 2;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sharkR = i;
                    sharkC = j;
                    map[i][j] = 0;
                }
            }
        }
    }
}
/*
7
3 5 0 6 4 5 5
1 6 3 3 0 2 2
6 2 1 3 1 5 1
9 2 2 3 4 2 3
2 1 6 2 0 0 4
4 5 0 6 1 1 0
5 4 3 2 1 4 0
*
* */