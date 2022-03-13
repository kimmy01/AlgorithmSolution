package com.algo2022_03;

import java.io.*;

public class Main11022 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            String[] tmp = br.readLine().split(" ");
            sb.append("Case #"+i+": "+Integer.parseInt(tmp[0])+" + "+Integer.parseInt(tmp[1])+" = "+(Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1])));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
