package com.algo11;

import java.util.*;
import java.io.*;

public class Main2204 {
    static String[] words, sortedWords;
    public static void main(String[] args) throws Exception {
        input();
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                return;
            }
            words = new String[N];
            sortedWords = new String[N];
            for(int i=0; i<N; i++){
                String word = br.readLine();
                words[i] = word;
                sortedWords[i] = word.toLowerCase();
            }
            Arrays.sort(sortedWords);
            for(int i=0; i<N; i++) {
                if(words[i].toLowerCase().equals(sortedWords[0])){
                    System.out.println(words[i]);
                    break;
                }
            }
        }
    }
}
