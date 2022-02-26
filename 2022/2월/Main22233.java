package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main22233 {
    static int N, M;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                String tmp = st.nextToken();
                if(set.contains(tmp)) set.remove(tmp);
            }
            bw.write(String.valueOf(set.size()));
            bw.newLine();
        }
        bw.flush();
    }
}
