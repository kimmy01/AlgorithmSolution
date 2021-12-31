package com.algo12;

import java.util.HashMap;

public class Solution모음사전 {
    static String[] selected;
    static int wordCnt;
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        String[] arr = {"A", "E", "I", "O", "U"};
        selected = new String[5];
        wordCnt = 0;
        for(int i=0; i<5; i++){
            selected[i] = "";
        }
        func(arr, 0);
        String word = "AAAAE";
        System.out.println(map.get(word));
    }
    static void func(String[] arr, int cnt){
        if(cnt > 0){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<5; i++){
                sb.append(selected[i]);
            }
            wordCnt++;
            map.put(sb.toString(), wordCnt);
        }
        if(cnt >= 5){
            return;
        }
        for(int i=0; i<5; i++){
            selected[cnt] = arr[i];
            func(arr, cnt+1);
            selected[cnt] = "";
        }
    }
}
