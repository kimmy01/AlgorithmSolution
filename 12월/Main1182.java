package com.algo12;

import java.util.*;
import java.io.*;

public class Main1182 {
    static int N, S, answer;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        input();
        func(0, 0);
        if(S == 0) answer--;
        System.out.println(answer);
    }
    static void func(int start, int num) {
        if(start == N) {
            if(num == S) answer++;
            return;
        }
        func(start+1, num+arr[start]);
        func(start+1, num);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
