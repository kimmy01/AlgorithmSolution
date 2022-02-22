package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main6064 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tmp = 0;
            int lcm = M*N/gcd(M, N);
            int answer = -1;
            while(tmp*M < lcm){
                if((tmp*M+x-y)%N == 0){
                    answer = tmp*M+x;
                    break;
                }
                tmp++;
            }
            System.out.println(answer);
        }
    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
