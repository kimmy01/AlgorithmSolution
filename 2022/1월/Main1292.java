package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main1292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];
        int idx = 1;
        loop: for(int i=1; i<100; i++){
            int limit = idx+i;
            for(int j=idx; j<limit; j++){
                if(idx > 1000) break loop;
                arr[idx] = i;
                idx++;
            }
        }
        int hap = 0;
        for(int i=A; i<=B; i++){
            hap+=arr[i];
        }
        System.out.println(hap);
    }
}
