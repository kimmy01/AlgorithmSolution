package com.algo0407;

import java.util.*;
import java.io.*;

public class Main_BOJ_1062_가르침 {
    static int N, K, answer;
    static boolean[] visited;
    static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        visited = new boolean[26];
        answer = 0;
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            words[i] = a.substring(4, a.length() - 4); //anta, tica 잘라주기
        }
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            K -= 5;
            visited['a' - 97] = true;
            visited['c' - 97] = true;
            visited['n' - 97] = true;
            visited['t' - 97] = true;
            visited['i' - 97] = true;
            DFS(0, 0);
            System.out.println(answer);
        }
    }

    static void DFS(int start, int count) {
        if (count == K) {
            int result = checkWords();
            answer = Math.max(answer, result);
            return;
        }
        for(int i=start; i<26; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(i, count+1);
                visited[i] = false;
            }
        }
    }

    static int checkWords() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            boolean check = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!visited[words[i].charAt(j) - 97]) {
                    check = false;
                    break;
                }
            }
            if (check) result++;
        }
        return result;
    }
}

