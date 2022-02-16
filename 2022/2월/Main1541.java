package com.algo2022_02;

import java.io.*;

public class Main1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("-");
        int answer = 0;
        for(int i=0; i<minus.length; i++){
            int tmp = 0;
            String[] add = minus[i].split("\\+");
            for(int j=0; j<add.length; j++){
                tmp += Integer.parseInt(add[j]);
            }
            if(i == 0) answer = tmp;
            else answer -= tmp;
        }
        System.out.println(answer);
    }
}
