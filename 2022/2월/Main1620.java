package com.algo2022_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1620 {
    static int N, M;
    static HashMap<String, Integer> findNumber = new HashMap<>();
    static HashMap<Integer, String> findName = new HashMap<>();
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            findNumber.put(name, i);
            findName.put(i, name);
        }
        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            char c = tmp.charAt(0);
            if(Character.isDigit(c)){
                int num = Integer.parseInt(tmp);
                System.out.println(findName.get(num));
            }else{
                System.out.println(findNumber.get(tmp));
            }
        }
    }
}
