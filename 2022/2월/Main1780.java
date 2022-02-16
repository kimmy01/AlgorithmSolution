package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1780 {
    static int N;
    static int[][] map;
    static int[] answer = new int[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, N);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }
    static void partition(int row, int col, int size){
        if(check(row, col, size)){
            if(map[row][col] == -1) answer[0]++;
            if(map[row][col] == 0) answer[1]++;
            if(map[row][col] == 1) answer[2]++;
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + 2 * newSize, newSize);

        partition(row + 2 * newSize, col, newSize);
        partition(row + 2 * newSize, col + newSize, newSize);
        partition(row + 2 * newSize, col + 2 * newSize, newSize);
    }
    static boolean check(int row, int col, int size){
        int color = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
