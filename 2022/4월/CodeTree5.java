package com.algo2022_04;

import java.io.*;
import java.util.*;

public class CodeTree5 {
    static int n, answer;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0);
        System.out.println(answer);
    }
    static void func(int cnt, int hap){
        answer = Math.max(hap, answer);
        if(cnt == 4)
            return;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && !visited[i][j+1] && inRange(i, j+1)){
                    visited[i][j] = true;
                    visited[i][j+1] = true;
                    func(cnt+1, hap+map[i][j]+map[i][j+1]);
                    visited[i][j] = false;
                    visited[i][j+1] = false;
                }
                if(!visited[i][j] && !visited[i+1][j] && inRange(i+1, j)) {
                    visited[i][j] = true;
                    visited[i+1][j] = true;
                    func(cnt+1, hap+map[i][j]+map[i+1][j]);
                    visited[i][j] = false;
                    visited[i+1][j] = false;
                }
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<n && 0<=nc && nc<n) return true;
        return false;
    }
}
