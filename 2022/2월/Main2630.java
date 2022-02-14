package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main2630 {
    static int N, white, blue;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    static void partition(int row, int col, int size) {
        if(check(row, col, size)){
            if(map[row][col] == 0) white++;
            else blue++;
            return;
        }
        int newSize = size/2;
        partition(row, col, newSize);
        partition(row, col+newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
    }
    static boolean check(int row, int col, int size) {
        int color = map[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(map[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
