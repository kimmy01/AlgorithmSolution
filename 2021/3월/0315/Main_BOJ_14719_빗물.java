package com.algo0315;
import java.util.*;
import java.io.*;
public class Main_BOJ_14719_빗물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        int[] blocks = new int[W];
        int left = 0;
        int right = 0;
        int result = 0;
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) {
            int a = Integer.parseInt(stk.nextToken());
            blocks[i] = a;
        }
        for(int i=1; i<W-1; i++){
            left = right = 0;
            for(int j=0; j<i; j++){
                left = Math.max(left, blocks[j]);
            }
            for(int j=i+1; j<W; j++){
                right = Math.max(right, blocks[j]);
            }
            if(blocks[i] < left && blocks[i] < right){
                result += Math.min(left, right) - blocks[i];
            }
        }
        System.out.println(result);
    }
}