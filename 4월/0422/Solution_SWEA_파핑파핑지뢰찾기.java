package com.algo0422;
import java.io.*;
import java.util.*;
public class Solution_SWEA_파핑파핑지뢰찾기 {
    static int N;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; //상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; //상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                String s = br.readLine();
                for(int j=0; j<N; j++){
                    map[i][j] = s.charAt(j);
                }
            }
            int answer = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] != '.') continue;
                    if(count(i, j) == 0){
                        answer++;
                        BFS(i, j);
                    }
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == '.') answer++;
                }
            }
            System.out.println("#"+t+" "+answer);
        }
    }
    static void BFS(int r, int c){
        visited[r][c] = true;
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cnt = count(tmp[0], tmp[1]);
            map[tmp[0]][tmp[1]] = (char) (cnt + '0');
            if(cnt != 0) continue;
            for(int i=0; i<8; i++){
                int nr = tmp[0]+dr[i];
                int nc = tmp[1]+dc[i];
                if(inRange(nr, nc) && map[nr][nc]=='.' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
    static int count(int r, int c){
        int count = 0;
        for(int i=0; i<8; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(inRange(nr, nc) && map[nr][nc] == '*') count++;
        }
        return count;
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<N) return true;
        return false;
    }
}
