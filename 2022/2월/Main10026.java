package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main10026 {
    static int N;
    static char[][] map1;
    static char[][] map2;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int answer1 = bfs(map1);
        int answer2 = bfs(map2);
        System.out.println(answer1+" "+answer2);
    }
    static int bfs(char[][] map){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;
                queue.add(i*N+j);
                visited[i][j] = true;
                answer++;
                while(!queue.isEmpty()){
                    int now = queue.poll();
                    int r = now/N;
                    int c = now%N;
                    for(int k=0; k<4; k++){
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if(nr < 0 || nr >=N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                        if(map[nr][nc] == map[r][c]){
                            queue.add(nr*N+nc);
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map1 = new char[N][N];
        map2 = new char[N][N];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                map1[i][j] = tmp.charAt(j);
                if(map1[i][j] == 'G'){
                    map2[i][j] = 'R';
                    continue;
                }
                map2[i][j] = map1[i][j];
            }
        }
    }
}
