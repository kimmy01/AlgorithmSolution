package com.algo0411;
import javax.security.auth.x500.X500Principal;
import java.util.*;
import java.io.*;
public class Main_BOJ_16234_인구이동 {
    static int N, L, R;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] map2;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true){
            int count = 0;
            visited = new boolean[N][N];
            map2 = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        BFS(i, j, ++count);
                    }
                }
            }
            if(count == 0) break;
            answer++;
        }
        System.out.println(answer);
    }
    static void BFS(int r, int c, int count){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        map2[r][c] = count;
        int sum = map[r][c];
        int nations = 1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0; i<4; i++){
                int nr = temp[0]+dr[i];
                int nc = temp[1]+dc[i];
                if(inRange(nr, nc) && !visited[nr][nc]){
                    int minus = Math.abs(map[temp[0]][temp[1]] - map[nr][nc]);
                    if(L<=minus && minus <= R){
                        visited[nr][nc] = true;
                        map2[nr][nc] = count;
                        sum += map[nr][nc];
                        nations++;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        int population = sum/nations;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map2[i][j] == count){
                    map[i][j] = population;
                }
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<N) return true;
        return false;
    }
}
