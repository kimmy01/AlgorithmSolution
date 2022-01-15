package com.algo2022_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2141 {
    static int N;
    static long hap;
    static long answer;
    static long[][] town;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        long sum = 0;
        for(int i=0; i<N; i++){
            sum += town[i][1];
            if(sum >= (hap+1)/2){
                System.out.println(town[i][0]);
                break;
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        town = new long[N][2];
        hap = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            town[i][0] = Integer.parseInt(st.nextToken());
            town[i][1] = Integer.parseInt(st.nextToken());
            hap += town[i][1];
        }
        Arrays.sort(town, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] == o2[0]){
                    return (int) (o1[1] - o2[1]);
                }
                return (int) (o1[0] - o2[0]);
            }
        });
    }
}
