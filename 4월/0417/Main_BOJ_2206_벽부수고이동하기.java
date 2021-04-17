package com.algo0417;
import java.io.*;
import java.util.*;
public class Main_BOJ_2206_벽부수고이동하기 {
    static class Point{
        int r;
        int c;
        int wall;
        int time;
        public Point(int r, int c, int wall, int time){
            this.r = r;
            this.c = c;
            this.wall = wall;
            this.time = time;
        }
    }
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[2][N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        BFS(0, 0);
    }
    static void BFS(int r, int c){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, 0, 1)); //행, 열, 벽부순횟수, 값
        visited[0][r][c] = true;
        visited[1][r][c] = true;
        while(!q.isEmpty()){
            Point current = q.poll();
            if(current.r == N-1 && current.c == M-1){
                System.out.println(current.time);
                return;
            }
            for(int i=0; i<4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                int wall = current.wall;
                int time = current.time;
                if(inRange(nr, nc)){
                    if(map[nr][nc] == 1){
                        if(wall == 0 && !visited[1][nr][nc]){
                            visited[1][nr][nc] = true;
                            q.add(new Point(nr, nc, 1, time+1));
                        }
                    }else{
                        if(!visited[wall][nr][nc]){
                            q.add(new Point(nr, nc, wall, time+1));
                            visited[wall][nr][nc] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<M) return true;
        return false;
    }
}
