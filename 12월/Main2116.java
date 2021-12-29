package com.algo12;

import java.util.*;
import java.io.*;

public class Main2116 {
    static int N, answer;
    static int[][] dices;
    static boolean[][] visited;
    //0-5, 1-3, 2-4
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        answer = 0;
        for(int i=0; i<6; i++){ //맨아래 주사위 어디를 위로 보낼지
            visited = new boolean[N][6];
            visited[0][i] = true;
            visitedDice(i, 0);
            checkDice(dices[0][i], 1);
            int tmp = 0;
            for(int j=0; j<N; j++){
                tmp += findMaxNum(j);
            }
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
    static int findMaxNum(int dice){
        int max = 0;
        for(int i=0; i<6; i++){
            if(!visited[dice][i]){
                max = Math.max(max, dices[dice][i]);
            }
        }
        return max;
    }
    static void checkDice(int num, int dice) {
        if(dice == N) return;
        int idx = 0;
        int nextNum = 0;
        for(int i=0; i<6; i++){
            if(dices[dice][i] == num){
                idx = i;
                visited[dice][i] = true;
                break;
            }
        }
        nextNum = visitedDice(idx, dice);
        checkDice(nextNum, dice+1);
    }
    static int visitedDice(int idx, int dice){
        int nextNum = 0;
        switch(idx){
            case 0:
                visited[dice][5] = true;
                nextNum = dices[dice][5];
                break;
            case 1:
                visited[dice][3] = true;
                nextNum = dices[dice][3];
                break;
            case 2:
                visited[dice][4] = true;
                nextNum = dices[dice][4];
                break;
            case 3:
                visited[dice][1] = true;
                nextNum = dices[dice][1];
                break;
            case 4:
                visited[dice][2] = true;
                nextNum = dices[dice][2];
                break;
            case 5:
                visited[dice][0] = true;
                nextNum = dices[dice][0];
                break;
        }
        return nextNum;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dices = new int[N][6];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<6; j++){
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
