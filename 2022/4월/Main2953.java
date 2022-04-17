package com.algo2022_04;

import java.io.*;
import java.util.StringTokenizer;

public class Main2953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int man = 0;
        int score = 0;
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int tmp = 0;
            for(int j=0; j<4; j++){
                tmp += Integer.parseInt(st.nextToken());
            }
            if(score < tmp){
                score = tmp;
                man = i+1;
            }
        }
        System.out.println(man + " " + score);
    }
}
