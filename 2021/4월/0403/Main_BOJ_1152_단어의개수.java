package com.algo0403;
import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_1152_단어의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        bw.write(String.valueOf(st.countTokens()));
        bw.flush();
    }
}
