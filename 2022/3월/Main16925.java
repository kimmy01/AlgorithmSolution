package com.algo2022_03;

import java.io.*;
import java.util.HashSet;

public class Main16925 {
    static int N;
    static String[] input;
    static String[] tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tmp = new String[2];
        input = new String[2*N-2];
        int idx = 0;
        for(int i=0; i<(2*N-2); i++){
            String s = br.readLine();
            input[i] = s;
            if(s.length() == N-1){
                tmp[idx] = s;
                idx++;
            }
        }
        makeWord();
    }
    static void makeWord(){
        String[] possible = new String[2];
        possible[0] = tmp[0] + tmp[1].charAt(N-2);
        possible[1] = tmp[1] + tmp[0].charAt(N-2);
        for(String p : possible){
            HashSet<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(String s : input){
                if(p.startsWith(s)){
                    if(!set.contains(s)){
                        set.add(s);
                        sb.append("P");
                    }else{
                        sb.append("S");
                    }
                }else{
                    if(p.endsWith(s))
                        sb.append("S");
                }
            }
            if(sb.length() == 2*N-2){
                System.out.println(p);
                System.out.println(sb.toString());
                return;
            }
        }
    }
}
