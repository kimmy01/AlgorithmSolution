package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main2064 {
    static int N, m;
    static String[] ipAddress;
    static String newIP;
    static String newMASK;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        checkM();
        makeIP();
        makeMask();
        System.out.println(newIP);
        System.out.println(newMASK);
    }

    static void checkM() {
        for (int k = 0; k < 32; k++) {
            boolean flag = true;
            for (int i = 0; i < N - 1; i++) {
                char a = ipAddress[i].charAt(k);
                char b = ipAddress[i + 1].charAt(k);
                if ((a ^ b) == 1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                m = k;
                break;
            }
            if(k == 31 && flag){
                m = 32;
            }
        }
    }

    static void makeIP() {
        StringBuilder sb = new StringBuilder();
        sb.append(ipAddress[0].substring(0, m));
        while(sb.length() < 32){
            sb.append("0");
        }
        newIP = calcBinary(sb.toString());
    }

    static void makeMask() {
        StringBuilder sb = new StringBuilder();
        while(sb.length() < m){
            sb.append("1");
        }
        while(sb.length() < 32){
            sb.append("0");
        }
        newMASK = calcBinary(sb.toString());
    }

    static String calcBinary(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            int a = Integer.parseInt(s.substring(i*8, (i*8)+8), 2);
            sb.append(a);
            if(i == 3) continue;
            sb.append(".");
        }
        return sb.toString();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ipAddress = new String[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            StringBuilder ip = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                StringBuilder sb = new StringBuilder();
                int tmp = Integer.parseInt(st.nextToken());
                sb.append(Integer.toBinaryString(tmp));
                while (sb.length() < 8) {
                    sb.insert(0, "0");
                }
                ip.append(sb);
            }
            ipAddress[i] = ip.toString();
        }
    }
}
