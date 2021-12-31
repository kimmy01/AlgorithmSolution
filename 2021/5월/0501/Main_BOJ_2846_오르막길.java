package com.algo0502;

import java.io.*;
import java.util.*;

public class Main_BOJ_2846_오르막길 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = -1;
        int check = 0;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            if (start == -1) {
                start = numbers[i];
                check = numbers[i];
                continue;
            }
            if (check < numbers[i]) {
                check = numbers[i];
                if (i == N - 1) {
                    maxHeight = Math.max(maxHeight, numbers[i] - start);
                }
            } else {
                maxHeight = Math.max(maxHeight, numbers[i - 1] - start);
                start = numbers[i];
                check = numbers[i];
            }
        }
        System.out.println(maxHeight);
    }
}
