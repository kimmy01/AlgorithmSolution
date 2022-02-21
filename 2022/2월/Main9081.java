package com.algo2022_02;

import java.io.*;
import java.util.*;

public class Main9081 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String s = br.readLine();
            System.out.println(func(s));
        }
    }
    static String func(String s) {
        char[] c = s.toCharArray();
        int idx1 = -1;
        int idx2 = 0;
        char tmp;
        for(int i=c.length-1; i>0; i--){
            if(c[i-1] < c[i]){
                idx1 = i-1; break;
            }
        }
        if(idx1 == -1) return s;
        else{
            for(int i=c.length-1; i>=0; i--){
                if(c[idx1] < c[i]){
                    idx2 = i; break;
                }
            }
            tmp = c[idx1];
            c[idx1] = c[idx2];
            c[idx2] = tmp;
            Arrays.sort(c, idx1+1, c.length);
            String answer = new String(c);
            return answer;
        }
    }
}
