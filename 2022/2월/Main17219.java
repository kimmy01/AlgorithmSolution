package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main17219 {
    static int N, M;
    static HashMap<String, String> hashMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            hashMap.put(st.nextToken(), st.nextToken());
        }
        for(int i=0; i<M; i++){
            bw.write(hashMap.get(br.readLine()));
            bw.newLine();
        }
        bw.flush();
    }
}
