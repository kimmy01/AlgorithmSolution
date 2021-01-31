package com.victoria;

import java.io.*;
import java.util.StringTokenizer;

public class Snail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer stk = new StringTokenizer(str);
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int V = Integer.parseInt(stk.nextToken());

        int day = 0;

        if(((V-A)%(A-B)) > 0){
            day = (V-A)/(A-B)+2;
        }else{
            day = (V-A)/(A-B)+1;
        }

        bw.write(String.valueOf(day));
        bw.flush();
    }
}
