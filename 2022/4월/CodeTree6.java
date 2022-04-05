package com.algo2022_04;

import java.util.*;
import java.io.*;

public class CodeTree6 {
    static int a, b, namuA, namuB, exitA, exitB;
    static int[][] ghost;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> ghostSpot = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        ghost = new int[a][b];
        for(int i=0; i<a; i++){
            Arrays.fill(ghost[i], -1);
        }
        map = new char[a][b];
        for(int i=0; i<a; i++){
            String tmp = br.readLine();
            for(int j=0; j<b; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'G')
                    ghostSpot.add(new int[]{i, j, 0});
                if(map[i][j] == 'N'){
                    namuA = i;
                    namuB = j;
                }
                if(map[i][j] == 'D'){
                    exitA = i;
                    exitB = j;
                }
            }
        }
        moveGhost();
        moveNamu();
    }
    static void moveNamu(){
        boolean[][] visited = new boolean[a][b];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{namuA, namuB, 0});
        visited[namuA][namuB] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(ghost[now[0]][now[1]] != -1 && ghost[now[0]][now[1]] <= now[2]){
                continue;
            }
            if(map[now[0]][now[1]] == 'D'){
                System.out.println("Yes");
                return;
            }
            for(int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(inRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != '#'){
                    queue.add(new int[]{nr, nc, now[2]+1});
                    visited[nr][nc] = true;
                }
            }
        }
        System.out.println("No");
    }
    static void moveGhost(){
        boolean[][] visited = new boolean[a][b];
        while(!ghostSpot.isEmpty()){
            int[] now = ghostSpot.poll();
            visited[now[0]][now[1]] = true;
            ghost[now[0]][now[1]] = now[2];
            for(int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(inRange(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    ghostSpot.add(new int[]{nr, nc, now[2]+1});
                }
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<a && 0<=nc && nc<b) return true;
        return false;
    }
}
