package com.algo0328;

import java.util.*;
import java.io.*;

public class Main_BOJ_6603_로또 {
    static int N;
    static int[] selected;
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            array = new int[N];
            selected = new int[6];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            Comb(0, 0);
            System.out.println();
        }
    }

    static void Comb(int cnt, int start) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
            selected[cnt] = array[i];
            Comb(cnt + 1, i + 1);
        }
    }
}
