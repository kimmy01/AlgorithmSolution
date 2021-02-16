package com.algo0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6485_삼성시의버스노선 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[]A = new int[N];
            int[]B = new int[N];
            for(int i=0; i<N; i++){
                stk = new StringTokenizer(br.readLine(), " ");
                A[i] = Integer.parseInt(stk.nextToken());
                B[i] = Integer.parseInt(stk.nextToken());
            }
            int P = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<P; i++){
                int num = Integer.parseInt(br.readLine());
                int cnt = 0;
                for(int j=0; j<N; j++){
                    if(A[j]<=num && num<=B[j]) cnt++;
                }
                sb.append(cnt+" ");
            }
            System.out.print("#"+t+" ");
            System.out.println(sb);
        }
    }
}
