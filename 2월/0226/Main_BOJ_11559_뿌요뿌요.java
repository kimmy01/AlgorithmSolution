package com.algo0226;
import java.io.*;
import java.util.*;
class dot{
    int x;
    int y;
    public dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main_BOJ_11559_뿌요뿌요 {
    static int n = 12, m = 6, bombcount, total;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bombcount = 0;
        total = 0;
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String a = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = a.charAt(j);
            }
        }

        while (true) {
            visited = new boolean[12][6];
            bombcount = 0;
            for (int i = 11; i >= 0; i--) {//밑에서부터 탐색
                for (int j = 5; j >= 0; j--) {
                    if (map[i][j] != '.' ){
                        bfs(new dot(i, j));
                    }
                }
            }
            if (bombcount == 0) {
                break;
            } else {
                total++;
            }
            down();
        }
        System.out.println(total);
    }

    static void bfs(dot d) {
        char check = map[d.x][d.y];
        int count = 0;
        Queue<dot> queue = new LinkedList<>();
        ArrayList<dot> save = new ArrayList<>();
        visited[d.x][d.y] = true;
        queue.add(d);

        while (!queue.isEmpty()) {
            dot t = queue.poll();
            save.add(t);
            count++;

            for (int i = 0; i < 4; i++) {
                int x1 = t.x + dx[i];
                int y1 = t.y + dy[i];
                if (0 <= x1 && x1 < 12 && 0 <= y1 && y1 < 6 && !visited[x1][y1] && map[x1][y1]==check) {
                    visited[x1][y1] = true;
                    queue.add(new dot(x1, y1));
                }
            }
        }
        if (count >= 4) {
            bombcount++;
            for (int i=0; i<save.size(); i++){
                dot temp = save.get(i);
                map[temp.x][temp.y] = '.';
            }
        }
    }
    static void down(){
        for(int i=11; i>=0; i--){
            for(int j=5; j>=0; j--){
                if(map[i][j] != '.'){
                    goDown(i, j);
                }
            }
        }
    }

    static void goDown(int a, int b){
        int tmp = -1;
        for(int i=11; i>a; i--){
            if(map[i][b] == '.'){
                tmp = i;
                break;
            }
        }
        if(tmp!=-1){
            char color = map[a][b];
            map[tmp][b] = color;
        }
    }
}