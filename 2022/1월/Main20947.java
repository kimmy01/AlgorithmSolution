package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main20947 {
    static int N;
    static char[][] map;
    static int[][] numberMap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<int[]> position2 = new ArrayList<>(); //건물
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        notBomb();
        bomb();
    }
    static void notBomb(){
        for(int i=0; i<position2.size(); i++){
            int r = position2.get(i)[0];
            int c = position2.get(i)[1];
            for(int j=0; j<4; j++){
                int nr = r;
                int nc = c;
                while(true){
                    nr += dr[j];
                    nc += dc[j];
                    if(0<=nr && nr<N && 0<=nc && nc<N && numberMap[nr][nc] != -1){
                        numberMap[nr][nc] = -2;
                    }else{
                        break;
                    }
                }
            }
        }
    }
    static void bomb(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(numberMap[i][j] == 0){
                    map[i][j] = 'B';
                }
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        numberMap = new int[N][N];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'X'){ //잔해
                    numberMap[i][j] = -1;
                }else if(map[i][j] == 'O'){ //건물
                    numberMap[i][j] = -1;
                    position2.add(new int[]{i, j});
                }else{ //빈칸
                    numberMap[i][j] = 0;
                }
            }
        }
    }
}
