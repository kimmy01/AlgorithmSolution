package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main2525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        int hour = A;
        int minute = B+C;
        while(minute >= 60){
            minute -= 60;
            hour += 1;
        }
        if(hour >= 24){
            hour -= 24;
        }
        System.out.println(hour+" "+minute);
    }
}
