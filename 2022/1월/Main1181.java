package com.algo2022_01;

import java.io.*;
import java.util.*;

public class Main1181 {
    static int N;
    static String[] words;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        for(int i=0; i<N; i++){
            if(i > 0 && words[i].equals(words[i-1])){
                continue;
            }
            System.out.println(words[i]);
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }
    }
}
