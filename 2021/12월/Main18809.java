package com.algo12;

import java.util.*;
import java.io.*;

public class Main18809 {
    static class Node{
        int r;
        int c;
        char color;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
        public Node(int r, int c, char color){
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
    static int N, M, G, R, answer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] garden;
    static boolean[] g;
    static boolean[] visited; //방문체크
    static Node[] selected; //선택된 위치
    static ArrayList<Node> nodeList;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        perm(0, 0);
        System.out.println(answer);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        garden = new int[N][M];
        nodeList = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                garden[i][j] = Integer.parseInt(st.nextToken());
                if(garden[i][j] == 2){
                    nodeList.add(new Node(i, j));
                }
            }
        }
        g = new boolean[G+R];
        visited = new boolean[nodeList.size()];
        selected = new Node[G+R];
    }
    static void perm(int depth, int index){ //배양액 뿌릴 땅 고르기
        if(depth == G+R){
            selectG(0, 0);
            return;
        }
        for(int i=index; i<nodeList.size(); i++){
            visited[i] = true;
            selected[depth] = nodeList.get(i);
            perm(depth+1, i+1);
            visited[i] = false;
        }
    }
    static void selectG(int depth, int index){ //초록배양액 뿌릴 땅 고르기
        if(depth == G){
            int tmp = bfs();
            answer = Math.max(answer, tmp);
            return;
        }
        for(int i=index; i<selected.length; i++){
            g[i] = true;
            selectG(depth+1, i+1);
            g[i] = false;
        }
    }
    static int bfs(){ //배양액 퍼뜨리기
        int[][] copied = copyMap(garden);
        int[][] time = new int[N][M];
        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<selected.length; i++){
            Node node = selected[i];
            if(g[i]){
                queue.add(new Node(node.r, node.c, 'G'));
                copied[node.r][node.c] = 3; //초록배양액 넣기
            }
        }
        for(int i=0; i<selected.length; i++){
            Node node = selected[i];
            if(!g[i]){
                queue.add(new Node(node.r, node.c, 'R'));
                copied[node.r][node.c] = 4; //빨강배양액 넣기
            }
        }

        int cnt = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(copied[now.r][now.c] == 5){ //꽃핌
                continue;
            }

            for(int i=0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(inRange(nr, nc)){
                    if(copied[nr][nc] == 1 || copied[nr][nc] == 2){ //뿌릴 수 있음
                        if(now.color == 'G'){
                            copied[nr][nc] = 3;
                        }else{
                            copied[nr][nc] = 4;
                        }
                        queue.add(new Node(nr, nc, now.color));
                        time[nr][nc] = time[now.r][now.c] + 1;
                    }else if(now.color == 'R' && copied[nr][nc] == 3 && time[nr][nc] == time[now.r][now.c] + 1){
                        copied[nr][nc] = 5;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    static int[][] copyMap(int[][] origin){ //배열 복사
        int[][] copied = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copied[i][j] = origin[i][j];
            }
        }
        return copied;
    }
    static boolean inRange(int nr, int nc){ //범위체크
        if(0<=nr && nr<N && 0<=nc && nc<M) return true;
        return false;
    }
}
