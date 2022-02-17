package com.algo2022_02;

import java.io.*;
import java.util.*;

public class Main11286 {
    static int N;
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                if(pq1.isEmpty() && pq2.isEmpty()){
                    bw.write(String.valueOf(0));
                    bw.newLine();
                    continue;
                }else if(pq1.isEmpty()){
                    bw.write(String.valueOf(pq2.poll()));
                    bw.newLine();
                    continue;
                }else if(pq2.isEmpty()){
                    bw.write(String.valueOf(pq1.poll()));
                    bw.newLine();
                    continue;
                }
                int tmp1 = pq1.peek();
                int tmp2 = -1*pq2.peek();
                if(tmp1 < tmp2){
                    bw.write(String.valueOf(pq1.poll()));
                }else if(tmp1 > tmp2 || tmp1 == tmp2){
                    bw.write(String.valueOf(pq2.poll()));
                }
                bw.newLine();
            }else{
                if(n > 0){
                    pq1.add(n);
                }else{
                    pq2.add(n);
                }
            }
        }
        bw.flush();
    }
}
