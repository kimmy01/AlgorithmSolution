package com.algo2022_03;

import java.awt.*;
import java.util.*;
import java.io.*;

public class Main1938 {
    static class State{
        int x, y, dir, dist;
        public State(){
            super();
        }
        State(int x, int y, int dir, int dist){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dist = dist;
        }
    }
    static int N;
    static char[][] map;
    static Point[] positionB;
    static Point[] positionE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        positionE = new Point[3];
        positionB = new Point[3];
        int pB = 0;
        int pE = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                char tmp = s.charAt(j);
                map[i][j] = tmp;
                if(tmp == 'B'){
                    positionB[pB++] = new Point(i, j);
                }else if(tmp == 'E'){
                    map[i][j] = 'E';
                    positionE[pE++] = new Point(i, j);
                }
            }
        }
        System.out.println(func());
    }
    static int func(){
        boolean[][][] visited = new boolean[2][N][N];
        Queue<State> queue = new LinkedList<>();
        int dir = 0;
        if(positionB[0].y + 1 == positionB[1].y) dir = 0;
        else dir = 1;
        queue.add(new State(positionB[1].x, positionB[1].y, dir, 0));
        visited[dir][positionB[1].x][positionB[1].y] = true;
        while(!queue.isEmpty()){
            State now = queue.poll();

            if(now.x == positionE[1].x & now.y == positionE[1].y){
                if(now.dir == 0 && map[now.x][now.y-1] == 'E' && map[now.x][now.y+1] == 'E'){
                    return now.dist;
                }else if(now.dir == 1 && map[now.x-1][now.y] == 'E' && map[now.x+1][now.y] == 'E'){
                    return now.dist;
                }
            }

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(now.dir == 0){
                    if(now.dir == 0){
                        if(!checkHorizon(nx, ny, i)) continue;
                    }
                }else{
                    if(!checkVertical(nx, ny, i)) continue;
                }
                if(visited[now.dir][nx][ny]) continue;
                visited[now.dir][nx][ny] = true;
                queue.add(new State(nx, ny, now.dir, now.dist+1));
            }
            if(possibleTurn(now.x, now.y)){
                if(now.dir == 0 && !visited[1][now.x][now.y]){
                    visited[1][now.x][now.y] = true;
                    queue.add(new State(now.x, now.y, 1, now.dist+1));
                }else if(now.dir == 1 && !visited[0][now.x][now.y]){
                    visited[0][now.x][now.y] = true;
                    queue.add(new State(now.x, now.y, 0, now.dist+1));
                }
            }
        }
        return 0;
    }
    static boolean checkVertical(int nx, int ny, int d){
        if(d < 2){
            if(nx - 1 < 0 || nx + 1 >= N) return false;
            if(map[nx][ny] == '1' || map[nx-1][ny] == '1' || map[nx+1][ny] == '1') return false;
        }else{
            if(ny < 0 || ny >= N) return false;
            if(map[nx][ny] == '1' || map[nx-1][ny] == '1' || map[nx+1][ny] == '1') return false;
        }
        return true;
    }
    static boolean checkHorizon(int nx, int ny, int d){
        if(d < 2){
            if(nx < 0 || nx >= N) return false;
            if(map[nx][ny] == '1' || map[nx][ny-1] == '1' || map[nx][ny+1] == '1') return false;
        }else{
            if(ny - 1 < 0 || ny + 1 >= N) return false;
            if(map[nx][ny] == '1' || map[nx][ny-1] == '1' || map[nx][ny+1] == '1') return false;
        }
        return true;
    }
    static boolean possibleTurn(int x, int y){
        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){
                if(i < 0 || j < 0 || i >= N || j >= N) return false;
                if(map[i][j] == '1') return false;
            }
        }
        return true;
    }
}
