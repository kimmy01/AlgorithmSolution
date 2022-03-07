package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main1022 {
    static int r1, r2, c1, c2, startR, startC, l;
    static int[][] spiral;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        int arrR = r2 - r1 + 2;
        int arrC = c2 - c1 + 2;
        startR = 0;
        startC = 0;
        spiral = new int[arrR][arrC];
        makeSpiral();
        checkL();
        print();
    }
    static void makeSpiral(){
        // startR = 0, startC = 0
        if(startR <= r2 && r1 <= startR && startC <= c2 && c1 <= startC)
            spiral[startR - r1][startC - c1] = 1;
        startC++;
        int plus = 2;
        int num = 2;
        while(true){
            if(startR < 0 || startR > 10000 || startC < 0 || startC > 10000) break;
            for(int i=0; i<plus; i++){
                if(startR <= r2 && r1 <= startR && startC <= c2 && c1 <= startC)
                    spiral[startR - r1][startC - c1] = num;
                startR--;
                num++;
            }
            startR++;
            startC--;
            for(int i=0; i<plus; i++){
                if(startR <= r2 && r1 <= startR && startC <= c2 && c1 <= startC)
                    spiral[startR - r1][startC - c1] = num; // 1 0 => -1 2, r1 = -2, c1 = 2
                startC--;
                num++;
            }
            startR++;
            startC++;
            for(int i=0; i<plus; i++){
                if(startR <= r2 && r1 <= startR && startC <= c2 && c1 <= startC)
                    spiral[startR - r1][startC - c1] = num;
                startR++;
                num++;
            }
            startR--;
            startC++;
            for(int i=0; i<plus; i++){
                if(startR <= r2 && r1 <= startR && startC <= c2 && c1 <= startC)
                    spiral[startR - r1][startC - c1] = num;
                startC++;
                num++;
            }
            plus += 2;
        }
    }
    static void checkL(){
        int max = 0;
        for(int i=0; i< spiral.length; i++){
            for(int j=0; j< spiral[i].length; j++){
                max = Math.max(max, spiral[i][j]);
            }
        }
        l = String.valueOf(max).length();
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< spiral.length-1; i++){
            for(int j=0; j< spiral[i].length-1; j++){
                int n = l - String.valueOf(spiral[i][j]).length();
                while(n-- > 0){
                    sb.append(" ");
                }
                sb.append(spiral[i][j]);
                if(j<spiral[i].length-2)
                    sb.append(" ");
            }
            if(i<spiral.length-2)
                sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
