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
        long max = 0;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i == 0 || j == 0) {
                    LCS[i][j] = 0;
                    continue;
                }
                if(seungyeon.charAt(i-1) == answer.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    max = Math.max(max, LCS[i][j]);
                }else if((seungyeon.charAt(i-1) == 'i' && answer.charAt(j-1) == 'j') || (seungyeon.charAt(i-1) == 'i' && answer.charAt(j-1) == 'l')){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    max = Math.max(max, LCS[i][j]);
                }else if(seungyeon.charAt(i-1) == 'v' && answer.charAt(j-1) == 'w') {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    max = Math.max(max, LCS[i][j]);
                }else {
                    LCS[i][j] = 0;
                }
            }
        }
        if(seungyeon.length() > answer.length()){
            System.out.println(seungyeon.length() - max);
        }else if(seungyeon.length() < answer.length()){
            System.out.println(answer.length() - (seungyeon.length() - max));
        }else{
            System.out.println(answer.length() - max);
        }
    }
}
