package com.algo2022_01;

import java.io.*;
import java.util.*;

public class Main1085 {
    static int x, y, w, h;
    public static void main(String[] args) throws Exception {
        input();
        calc();
    }
    static void calc() {
        int a = x;
        int b = y;
        int c = w-x;
        int d = h-y;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
    }
}
