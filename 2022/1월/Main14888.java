package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main14888 {
    static int N, max, min;
    static int[] numbers, operators;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        recursion(0, new int[N-1], operators);
        System.out.println(max);
        System.out.println(min);
    }
    static void recursion(int cnt, int[] result, int[] operators) {
        if(cnt == N-1){
            int tmp = 0;
            for(int i=0; i<N; i++){
                if(i == 0){
                    tmp = numbers[i];
                    continue;
                }
                if(result[i-1] == 1){
                    tmp += numbers[i];
                }else if(result[i-1] == 2){
                    tmp -= numbers[i];
                }else if(result[i-1] == 3){
                    tmp *= numbers[i];
                }else if(result[i-1] == 4){
                    tmp /= numbers[i];
                }
            }
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
            return;
        }
        for(int i=0; i<4; i++){
            if(operators[i] != 0){
                result[cnt] = i+1;
                operators[i]--;
                recursion(cnt+1, result, operators);
                operators[i]++;
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
    }
}
