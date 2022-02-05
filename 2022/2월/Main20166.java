package com.algo2022_02;

import java.io.*;
import java.util.*;

public class Main20166 {
    static int N, M, K;
    static char[][] map;
    static String[] words;
    static HashMap<Character, ArrayList<int[]>> hashMap = new HashMap<>();
    static HashMap<String, Integer> wordMap = new HashMap<>();
    static int[] answer;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; //상 우상 우 우하 하 좌하 좌 좌상
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++){
            String now = words[i];
            if(!wordMap.containsKey(now)){
                wordMap.put(now, 0);
                if(hashMap.containsKey(now.charAt(0))){
                    ArrayList<int[]> tmpList = hashMap.get(now.charAt(0));
                    for(int[] arr : tmpList){
                        dfs(now,1, arr[0], arr[1]);
                    }
                }
            }
            sb.append(wordMap.get(now)+ "\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(String word, int cnt, int r, int c) {
        if(cnt == word.length()){
            wordMap.put(word, wordMap.get(word)+1);
            return;
        }
        for(int i=0; i<8; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr == 0){
                nr = N;
            }else if(nr == N+1){
                nr = 1;
            }
            if(nc == 0){
                nc = M;
            }else if(nc == M+1){
                nc = 1;
            }
            if(map[nr][nc] == word.charAt(cnt)){
                dfs(word,cnt+1, nr, nc);
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        words = new String[K];
        answer = new int[K];
        for(int i=1; i<=N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = j+1;
                map[i][j+1] = tmp.charAt(j);
                ArrayList<int[]> list = new ArrayList<>();
                if(hashMap.containsKey(map[i][j+1])){
                    list = hashMap.get(map[i][j+1]);
                    list.add(arr);
                }else{
                    list.add(arr);
                }
                hashMap.put(map[i][j+1], list);
            }
        }
        for(int i=0; i<K; i++){
            words[i] = br.readLine();
        }
    }
}
