package com.algo2022_02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.io.*;

public class Main15671 {
    static int N, flag = -1;
    static int[][] arr;
    static int[][] othello;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<N; i++){
            game(arr[i][0], arr[i][1]);
            flag *= -1;
        }
        print();
    }
    static void game(int r, int c) {
        othello[r][c] = flag;
        for(int i=0; i<8; i++){
            Queue<int[]> queue = new LinkedList<>();
            boolean change = true; //false일때 변경
            int nr = r + dr[i];
            int nc = c + dc[i];
            while(true){
                if(0<nr && nr<=6 && 0<nc && nc<=6){
                    if(othello[nr][nc] == flag) {
                        change = false; break;
                    }else if(othello[nr][nc] == -1*flag) {
                        queue.add(new int[]{nr, nc});
                        nr += dr[i];
                        nc += dc[i];
                    }else if(othello[nr][nc] == 0){
                        break;
                    }
                }else{
                    break;
                }
            }
            if(!change){
                while(!queue.isEmpty()){
                    int[] now = queue.poll();
                    othello[now[0]][now[1]] = flag;
                }
            }
        }
    }
    static void print() {
        StringBuilder sb = new StringBuilder();
        int black = 0;
        int white = 0;
        for(int i=1; i<=6; i++){
            for(int j=1; j<=6; j++){
                if(othello[i][j] == 0) sb.append(".");
                else if(othello[i][j] == -1) {
                    sb.append("B"); black++;
                }else if(othello[i][j] == 1) {
                    sb.append("W"); white++;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        if (black > white) {
            System.out.println("Black");
        } else {
            System.out.println("White");
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        othello = new int[7][7];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            arr[i][0] = Integer.parseInt(tmp.split(" ")[0]);
            arr[i][1] = Integer.parseInt(tmp.split(" ")[1]);
        }
        othello[3][3] = 1; //흰
        othello[4][4] = 1;
        othello[3][4] = -1; //검
        othello[4][3] = -1;
    }
}
