package com.algo12;

import java.util.*;
import java.io.*;

public class Main15671 {
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int N;
    static char[][] map;
    static ArrayList<Point> stones;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; //상 우상 우 우하 하 좌하 좌 좌상
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; //상 우상 우 우하 하 좌하 좌 좌상
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[7][7];
        stones = new ArrayList<>();
        for(int i=1; i<=6; i++){
            for(int j=1; j<=6; j++){
                map[i][j] = '.';
            }
        }
        map[3][3] = 'W';
        map[4][4] = 'W';
        map[3][4] = 'B';
        map[4][3] = 'B';
        // map 초기화
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            stones.add(point);
        } // 돌 위치 입력
    }
    static void func() {
        for(int i=0; i<N; i++) {
            if (i % 2 == 0) { // 검돌
                turn(stones.get(i).r, stones.get(i).c, true);
            } else { //흰돌
                turn(stones.get(i).r, stones.get(i).c, false);
            }
        }
        count();
    }
    static void turn(int r, int c, boolean color) {
        Queue<Point> queue = new LinkedList<>();
        if(color){ // 검돌
            map[r][c] = 'B'; // 현재 위치 돌 놔주기
            for(int i=0; i<8; i++){ // 8방
                queue.clear();
                while(true){
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    if(inRange(nr, nc)){ // 범위 체크
                        if(map[nr][nc] == 'W'){ // 그 돌이 흰색이면 queue에 넣고 그 돌 위치로 r, c 바꿔줌
                            queue.add(new Point(nr, nc));
                            r = nr;
                            c = nc;
                        }else if(map[nr][nc] == 'B'){ // 그 돌이 검정색이면 이제 queue에 있는 흰 돌 좌표들 빼와서 검은색으로 바꿔줌
                            while(!queue.isEmpty()){
                                Point tmp = queue.poll();
                                map[tmp.r][tmp.c] = 'B';
                            }
                            break;
                        }else{
                            break;
                        } // . 만났을 때
                    }else{
                        break;
                    } // 범위 밖
                }
            }
        }else{ // 흰돌
            map[r][c] = 'W'; // 현재 위치 돌 놔주기
            for(int i=0; i<8; i++){
                queue.clear();
                while(true){
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    if(inRange(nr, nc)){ // 범위 체크
                        if(map[nr][nc] == 'B'){ // 그 돌이 검정색이면 queue에 넣고 그 돌 위치로 r, c 바꿔줌
                            queue.add(new Point(nr, nc));
                            r = nr;
                            c = nc;
                        }else if(map[nr][nc] == 'W'){ // 그 돌이 흰색이면 이제 queue에 있는 흰 돌 좌표들 빼와서 흰색으로 바꿔줌
                            while(!queue.isEmpty()){
                                Point tmp = queue.poll();
                                map[tmp.r][tmp.c] = 'W';
                            }
                            break;
                        }else{
                            break;
                        } // . 만났을 때
                    }else{
                        break;
                    } // 범위 밖
                }
            }
        }
    }
    static void count(){
        int blackCnt = 0;
        int whiteCnt = 0;
        for(int i=1; i<=6; i++){
            for(int j=1; j<=6; j++){
                System.out.print(map[i][j]);
                if(map[i][j] == 'B'){
                    blackCnt++;
                }else if(map[i][j] == 'W'){
                    whiteCnt++;
                }
            }
            System.out.println();
        } // 맵 출력하면서 검돌 흰돌 개수 세기
        if(blackCnt > whiteCnt){
            System.out.println("Black");
        }else{
            System.out.println("White");
        }
    }
    static boolean inRange(int nr, int nc){ // 범위체크
        if(1<=nr && nr<=6 && 1<=nc && nc<=6) return true;
        return false;
    }
}
