package com.algo0609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4317_칩생산 {
    static int H, W, answer;
    static int[] dr = {0, 0, 1, 1}; //우,하,우하
    static int[] dc = {0, 1, 0, 1}; //우,하,우하
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<W; j++){
                    int tmp = Integer.parseInt(st.nextToken());
                    if(tmp == 1){
                        map[i][j] = -1;
                    }else{
                        map[i][j] = tmp;
                    }
                }
            }//input
            func();
            System.out.println("#"+t+" "+answer);
//            for(int i=0; i<H; i++){
//                for(int j=0; j<W; j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
        }//TC
    }
    static void func(){
        int num = 1;
        for(int i=0; i<W; i++){
            for(int j=0; j<H; j++){
                boolean flag = true;
                for(int k=0; k<4; k++){
                    int nr = j + dr[k];
                    int nc = i + dc[k];
                    if(inRange(nr, nc) && map[nr][nc] == 0){
                        continue;
                    }else{
                        flag = false;
                    }
                }
                if(flag){
                    for(int k=0; k<4; k++){
                        int nr = j + dr[k];
                        int nc = i + dc[k];
                        map[nr][nc] = num;
                    }
                    num++;
                }
            }
        }
        answer = num-1;
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<H && 0<=nc && nc<W) return true;
        return false;
    }
}
