package com.algo0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_5356_의석이의세로로말해요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[][] words = new char[5][15];

        for(int t=1; t<=T; t++){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<5; i++){
                for(int j=0; j<15; j++){
                    words[i][j] = '-';
                }
            }

            for(int i=0; i<5; i++){
                String a = br.readLine();
                for(int j=0; j<a.length(); j++){
                    words[i][j] = a.charAt(j);
                }
            }

            for(int j=0; j<15; j++){
                for(int i=0; i<5; i++){
                    if(words[i][j] == '-'){
                        continue;
                    }
                    sb.append(words[i][j]);
                }
            }

            System.out.println("#"+t+" "+sb.toString());
        }
    }
}