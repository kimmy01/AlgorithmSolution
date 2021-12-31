package com.algo0412;
import java.io.*;
import java.util.*;
public class Solution_SWEA_1249_보급로 {
    static int N, minAnswer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0 ,-1, 1};
    static int[][] map;
    static int[][] answer;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i=0; i<N; i++){
                String a = br.readLine();
                for(int j=0; j<N; j++){
                    map[i][j] = a.charAt(j) - '0';
                }
            }
            visited = new boolean[N][N];
            answer = new int[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(answer[i], 123456789);
            }
            minAnswer = 123456789;
            answer[0][0] = 0;
            BFS();
            System.out.println("#"+t+" "+minAnswer);
        }
    }
    static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            if(r == N-1 && c == N-1){
                if(minAnswer > answer[N-1][N-1]){
                    minAnswer = answer[N-1][N-1];
                }
            }
            if(minAnswer <= answer[r][c]) continue;
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(inRange(nr, nc)){
                    if(!visited[nr][nc] || answer[nr][nc] > answer[r][c] + map[nr][nc]){
                        visited[nr][nc] = true;
                        answer[nr][nc] = answer[r][c] + map[nr][nc];
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<= nr && nr<N && 0<=nc && nc<N) return true;
        return false;
    }
}
