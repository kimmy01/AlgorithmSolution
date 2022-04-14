package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main1009 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = 1;
            for(int j=0; j<b; j++){
                result = (result*a)%10;
            }
            if(result == 0) System.out.println(10);
            else System.out.println(result);
        }
    }
}
