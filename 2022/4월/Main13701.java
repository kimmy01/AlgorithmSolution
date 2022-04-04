package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main13701 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BitSet set = new BitSet(33554432);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if(!set.get(n)){
                set.set(n);
                sb.append(n+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
