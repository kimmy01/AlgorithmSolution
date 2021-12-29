package com.algo12;

import java.util.*;
import java.io.*;

public class Main22945 {
    static int N, l, r, min, answer;
    static int[] skill;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        l = 0;
        r = N-1;
        answer = 0;

        while(l <= r){
            min = Math.min(skill[l], skill[r]);
            answer = Math.max((r-l-1)*min, answer);
            if(skill[l] < skill[r]){
                l++;
            }else{
                r--;
            }
        }

        System.out.println(answer);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        skill = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            skill[i] = Integer.parseInt(st.nextToken());
        }
    }
}
