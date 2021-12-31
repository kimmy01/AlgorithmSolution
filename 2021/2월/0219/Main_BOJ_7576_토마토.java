package com.algo0219;
import java.io.*;
import java.util.*;

public class Main_BOJ_7576_토마토 {
    static int M,N;
    static int[][] box;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken()); //가로줄
        M = Integer.parseInt(stk.nextToken()); //세로줄
        box = new int[M][N];
        for(int i=0; i<M; i++){
            String temp = br.readLine();
            StringTokenizer stk2 = new StringTokenizer(temp, " ");
            for(int j=0; j<N; j++){
                String a = stk2.nextToken();
                box[i][j] = Integer.parseInt(a);
            }
        }//입력
        tomato();
    }
    static int[] dM = {-1, 1, 0, 0};//상하좌우
    static int[] dN = {0, 0, -1, 1};//상하좌우
    static void tomato(){
        Queue<int[]> ripe = new LinkedList<>();
        int day = 0;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(box[i][j] == 1){
                    ripe.offer(new int[] {i, j, 0});
                }
            }
        }

        while(!ripe.isEmpty()){
            int curM = ripe.peek()[0];
            int curN = ripe.peek()[1];
            day = ripe.peek()[2];
            ripe.poll();

            for(int i=0; i<4; i++){
                int nM = curM+dM[i];
                int nN = curN+dN[i];
                if(0<=nM && nM<M && 0<=nN && nN<N){
                    if(box[nM][nN] == 0) {
                        box[nM][nN]=1; //안익었으면 익은 걸로 바꾸기
                        ripe.offer(new int[]{nM, nN, day+1});
                    }
                }
            }
        }
        if(checkTomato()){
            System.out.println(day);
        }else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato(){
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(box[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}