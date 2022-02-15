package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main9375 {
    static int T, N;
    static HashMap<String, ArrayList<String>> hashMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            hashMap = new HashMap<>();
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String clothes = st.nextToken();
                String category = st.nextToken();
                ArrayList<String> tmp = hashMap.getOrDefault(category, new ArrayList<>());
                tmp.add(clothes);
                hashMap.put(category, tmp);
            }
            int answer = 1;
            for(Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()){
                answer *= (entry.getValue().size()+1);
            }
            System.out.println(answer - 1);
        }
    }
}
