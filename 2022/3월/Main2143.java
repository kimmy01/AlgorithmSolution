package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main2143 {
    static int T, n, m;
    static int[] A, B;
    static HashMap<Integer, Integer> Amap = new HashMap<>();
    static HashMap<Integer, Integer> Bmap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        String[] a = br.readLine().split(" ");
        m = Integer.parseInt(br.readLine());
        B = new int[m];
        String[] b = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(a[i]);
            if(i > 0)
                A[i] += A[i-1];
        }
        for(int i=0; i<m; i++){
            B[i] = Integer.parseInt(b[i]);
            if(i > 0)
                B[i] += B[i-1];
        }
        makeArr();
        System.out.println(count());
    }
    static long count(){
        long cnt = 0;
        for(int a : Amap.keySet()){
            cnt = cnt + (long)Bmap.getOrDefault(T-a, 0) * (long)Amap.get(a);
        }
        return cnt;
    }
    static void makeArr(){ // 1 3 1 -1 2 =>
        for(int i=0; i<n; i++){
            Amap.put(A[i], Amap.getOrDefault(A[i], 0)+1);
            if(i == 0) continue;
            for(int j=0; j<i; j++){
                int tmp = A[i]-A[j];
                Amap.put(tmp, Amap.getOrDefault(tmp, 0)+1);
            }
        }
        for(int i=0; i<m; i++){
            Bmap.put(B[i], Bmap.getOrDefault(B[i], 0)+1);
            if(i == 0) continue;
            for(int j=0; j<i; j++){
                int tmp = B[i]-B[j];
                Bmap.put(tmp, Bmap.getOrDefault(tmp, 0)+1);
            }
        }
    }
}
