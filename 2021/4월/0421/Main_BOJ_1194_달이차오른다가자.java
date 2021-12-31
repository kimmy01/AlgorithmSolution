package com.algo0421;

import java.io.*;
import java.util.*;
public class Main_BOJ_1194_달이차오른다가자 {
    static class Node{
        int r;
        int c;
        int cnt;
        int key;
        public Node(int r, int c, int cnt, int key){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.key = key;
        }
    }
    static int N, M;
    static int answer = 123456789;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static Node start;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[64][N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == '0') { //시작지점
                    start = new Node(i, j, 0, 0);
                }
            }
        }
        int result = BFS();
        System.out.println(result);
    }
    static int BFS(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.r, start.c, 0, 0));
        visited[0][start.r][start.c] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int r = node.r;
            int c = node.c;
            int cnt = node.cnt;
            int key = node.key;
            if(map[r][c] == '1') return cnt;
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(inRange(nr, nc) && map[nr][nc] != '#'
                && !visited[key][nr][nc]){
                    if(map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1'){
                        visited[key][nr][nc] = true;
                        q.add(new Node(nr, nc, cnt+1, key));
                    } else if('a' <= map[nr][nc] && map[nr][nc] <= 'f'){
                        int newKey = 1 << (map[nr][nc] - 'a');
                        newKey = newKey | key;
                        if(!visited[newKey][nr][nc]){
                            visited[newKey][nr][nc] = true;
                            visited[key][nr][nc] = true;
                            q.add(new Node(nr, nc, cnt+1, newKey));
                        }
                    }else if('A' <= map[nr][nc] && map[nr][nc] <= 'F'){
                        int door = 1 << (map[nr][nc] - 'A');
                        if((key & door) > 0){
                            visited[key][nr][nc] = true;
                            q.add(new Node(nr, nc, cnt+1, key));
                        }
                    }
                }
            }
        }
        return -1;
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<M) return true;
        return false;
    }
}
