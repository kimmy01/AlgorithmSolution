package com.algo2022_05;

import java.io.*;
import java.util.*;

public class Main20542 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String seungyeon = br.readLine();
        String answer = br.readLine();
        int[][] LCS = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            LCS[i][0] = i;
        }
        for(int j=1; j<=m; j++){
            LCS[0][j] = j;
        }
        for(int j=1; j<=m; j++){
            for(int i=1; i<=n; i++){
                if(isCorrect(seungyeon.charAt(i-1), answer.charAt(j-1))){
                    LCS[i][j] = LCS[i-1][j-1];
                }else{
                    LCS[i][j] = Math.min(LCS[i-1][j-1]+1, Math.min(LCS[i-1][j]+1, LCS[i][j-1]+1));
                }
            }
        }
        System.out.println(LCS[n][m]);
    }
    static boolean isCorrect(char c1, char c2){
        if(c1 == c2) return true;
        else if(c1 == 'i' && (c2 == 'l' || c2 == 'j')) return true;
        else if(c1 == 'v' && c2 == 'w') return true;
        else return false;
    }
}
