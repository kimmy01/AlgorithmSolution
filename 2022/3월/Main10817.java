package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main10817 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        if((A >= B && B >= C) || (C >= B && B >= A)){
            System.out.println(B);
        }else if((A >= C && C >= B) || (B >= C && C >= A)){
            System.out.println(C);
        }else if((B >= A && A >= C) || (C >= A && A >= B)){
            System.out.println(A);
        }
    }
}
