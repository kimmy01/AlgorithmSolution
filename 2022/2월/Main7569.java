package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main7569 {
    static int M, N, H, tomatoCnt;
    static int[][][] tomatoBox;
    static int[] dr = {-1, 1, 0, 0, 0, 0}; //전후좌우상하
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        input();
        bfs();
    }
    static void bfs() {
        int day = -1;
        while(!queue.isEmpty()){
            day++;
            int size = queue.size();
            while(size-- > 0){
                int[] now = queue.poll();
                for(int i=0; i<6; i++){
                    int nr = now[0]+dr[i];
                    int nc = now[1]+dc[i];
                    int nh = now[2]+dh[i];
                    if(inRange(nr, nc, nh) && !visited[nr][nc][nh] && tomatoBox[nr][nc][nh] == 0){
                        visited[nr][nc][nh] = true;
                        tomatoBox[nr][nc][nh] = 1;
                        tomatoCnt--;
                        queue.add(new int[]{nr, nc, nh});
                    }
                }
            }
        }
        if(tomatoCnt == 0) System.out.println(day);
        else System.out.println(-1);
    }
    static boolean inRange(int nr, int nc, int nh){
        if(0<=nr && nr<N && 0<=nc && nc<M && 0<=nh && nh<H) return true;
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomatoBox = new int[N][M][H];
        visited = new boolean[N][M][H];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<M; k++){
                    tomatoBox[j][k][i] = Integer.parseInt(st.nextToken());
                    if(tomatoBox[j][k][i] == 1) {
                        queue.add(new int[]{j, k, i});
                        visited[j][k][i] = true;
                    }
                    if(tomatoBox[j][k][i] == 0) tomatoCnt++;
                }
            }
        }
    }
}
