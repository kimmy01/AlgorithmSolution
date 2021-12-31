package com.algo12;

import java.io.*;

public class Main9997 {
    static int N, answer;
    static int[] words;
    public static void main(String[] args) throws Exception {
        input();
        powerset(0, new boolean[N]);
        System.out.println(answer);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new int[N];
        for(int i=0; i<N; i++){
            int tmp = 1 << 26;
            String s = br.readLine();
            for(int j=0; j<s.length(); j++){
                tmp = tmp | 1 << (s.charAt(j) - 'a');
            }
            words[i] = tmp;
        }
    }
    static void powerset(int index, boolean[] selected){
        if(index == words.length){
            int tmp = 1 << 26;
            for(int i=0; i<selected.length; i++){
                if(selected[i]){
                    tmp = tmp | words[i];
                }
            }
            if(tmp == ((1 << 27) -1)){
                answer++;
            }
            return;
        }
        selected[index] = true;
        powerset(index+1, selected);
        selected[index] = false;
        powerset(index+1, selected);
    }
}
