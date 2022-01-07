package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main21610 {
    static int N, M;
    static int map[][];
    static int move[][];
    static int copyR[] = {-1, -1, 1, 1};
    static int copyC[] = {-1, 1, 1, -1};
    static int dr[] = {0, 0, -1, -1, -1, 0, 1, 1, 1}; //좌 좌상 상 우상 우 우하 하 좌하
    static int dc[] = {0, -1, -1, 0, 1, 1, 1, 0, -1}; //좌 좌상 상 우상 우 우하 하 좌하
    static ArrayList<int[]> clouds = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<M; i++){
            moveClouds(move[i][0], move[i][1]);
            pourRain();
            copyRain();
            makeClouds();
            countRain();
        }
        System.out.println(countRain());
    }
    static void moveClouds(int d, int s){
        for(int i=0; i<clouds.size(); i++){
            int nr = clouds.get(i)[0] + dr[d]*s;
            int nc = clouds.get(i)[1] + dc[d]*s;
            if(nr > N) {
                while(true){
                    if(nr <= N) break;
                    nr -= N;
                }
            }
            if(nr < 1) {
                while(true){
                    if(nr >= 1) break;
                    nr += N;
                }
            }
            if(nc > N) {
                while(true){
                    if(nc <= N) break;
                    nc -= N;
                }
            }
            if(nc < 1) {
                while(true){
                    if(nc >= 1) break;
                    nc += N;
                }
            }
            clouds.set(i, new int[]{nr, nc});
        }
    }
    static void pourRain() {
        for(int i=0; i<clouds.size(); i++){
            int r = clouds.get(i)[0];
            int c = clouds.get(i)[1];
            map[r][c]++;
        }
    }
    static void copyRain() {
        for(int i=0; i<clouds.size(); i++){
            int count = 0;
            int r = clouds.get(i)[0];
            int c = clouds.get(i)[1];
            for(int j=0; j<4; j++){
                int nr = r + copyR[j];
                int nc = c + copyC[j];
                if(0<nr && nr<=N && 0<nc && nc<=N){
                    if(map[nr][nc] > 0) count++;
                }
            }
            map[r][c] += count;
        }
    }
    static void makeClouds() {
        ArrayList<int[]> tmp = new ArrayList<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j] >= 2){
                    if(find(i, j)){
                        tmp.add(new int[]{i, j});
                        map[i][j] -= 2;
                    }
                }
            }
        }
        clouds.clear();
        for(int i=0; i<tmp.size(); i++){
            clouds.add(new int[]{tmp.get(i)[0], tmp.get(i)[1]});
        }
    }
    static boolean find(int r, int c){
        for(int i=0; i<clouds.size(); i++){
            int cloudR = clouds.get(i)[0];
            int cloudC = clouds.get(i)[1];
            if(cloudR == r && cloudC == c) return false;
        }
        return true;
    }
    static int countRain() {
        int count = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                count += map[i][j];
            }
        }
        return count;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        move = new int[M][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }
        clouds.add(new int[]{N, 1});
        clouds.add(new int[]{N, 2});
        clouds.add(new int[]{N-1, 1});
        clouds.add(new int[]{N-1, 2});
    }
}
