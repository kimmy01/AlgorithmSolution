package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17086_아기상어2 {
    static int[][] map;
    static int[] dx =  {-1, -1, -1, 0, 0, 1, 1, 1}; //좌상 상 우상 좌 우 좌하 하 우하;
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; //좌상 상 우상 좌 우 좌하 하 우하;
    static int N, M, answer, cx, cy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        answer = 0;
        cx = 0;
        cy = 0;
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                int input = Integer.parseInt(stk.nextToken());
                map[i][j] = input;
            }
        }
        int num;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1){
                    continue;
                }
                num = find(i, j);
                if(answer < num){
                    answer = num;
                }
            }
        }
        System.out.println(answer);
    }

    static int find(int x, int y){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<8; i++){
                int nx = current[0]+dx[i];
                int ny = current[1]+dy[i];
                int cnt = current[2];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(visited[nx][ny] == true) continue;
                    if(map[nx][ny] == 1) return cnt+1;
                }else{
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, cnt+1});
            }
        }
        return 0;
    }
}