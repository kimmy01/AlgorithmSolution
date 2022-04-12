package com.algo2022_04;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main2933 {
    static int R, C, N;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R+1][C+1];
        for(int i=1; i<=R; i++){
            String s = br.readLine();
            for(int j=1; j<=C; j++){
                map[i][j] = s.charAt(j-1);
            }
        }
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int h = Integer.parseInt(st.nextToken());
            h = R - h + 1;
            stick(h, i%2);
            down();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void stick(int h, int turn){
        int start;
        int dir;
        if(turn == 0){
            start = 1;
            dir = 1;
        }else{
            start = C;
            dir = -1;
        }
        int tmp = start;
        for(int i=0; i<C; i++){
            if(map[h][tmp] == 'x'){
                map[h][tmp] = '.';
                break;
            }
            tmp += dir;
        }
    }
    static void down(){
        boolean[][] visited = new boolean[R+1][C+1];
        ArrayList<Point> list = new ArrayList<>();
        for(int i=1; i<=C; i++){
            if(map[R][i] == '.' || visited[R][i]) continue;
            queue.add(new Point(R, i));
            visited[R][i] = true;
            while(!queue.isEmpty()){
                Point p = queue.poll();
                for(int j=0; j<4; j++){
                    int nr = p.x + dr[j];
                    int nc = p.y + dc[j];
                    if(inRange(nr, nc)){
                        if(map[nr][nc] == 'x' && !visited[nr][nc]){
                            visited[nr][nc] = true;
                            queue.add(new Point(nr, nc));
                        }
                    }
                }
            }
        }
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(!visited[i][j] && map[i][j] == 'x'){
                    list.add(new Point(i, j));
                    map[i][j] = '.';
                }
            }
        }
        if(list.isEmpty()) return;
        boolean flag = true;
        while(flag){
            for(Point p : list){
                int r = p.x + 1;
                int c = p.y;
                if(!inRange(r, c) || map[r][c] == 'x'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(Point p : list){
                    p.x++;
                }
            }
        }
        for(Point p : list){
            map[p.x][p.y] = 'x';
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<nr && nr<=R && 0<nc && nc<=C) return true;
        return false;
    }
}
