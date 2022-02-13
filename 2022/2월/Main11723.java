package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int set = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int n = 0;
            switch(command){
                case "add" : {
                    n = Integer.parseInt(st.nextToken());
                    set |= (1<<n);
                    break;
                }
                case "remove" : {
                    n = Integer.parseInt(st.nextToken());
                    set &= ~(1<<n);
                    break;
                }
                case "check" : {
                    n = Integer.parseInt(st.nextToken());
                    if((set & (1<<n)) == 0){
                        bw.write(String.valueOf(0));
                        bw.newLine();
                    }else{
                        bw.write(String.valueOf(1));
                        bw.newLine();
                    }
                    break;
                }
                case "toggle" : {
                    n = Integer.parseInt(st.nextToken());
                    set ^= (1<<n);
                    break;
                }
                case "all" : {
                    set = (1 << 21)-1;
                    break;
                }
                case "empty" : {
                    set = 0;
                    break;
                }
            }
        }
        bw.flush();
    }
}
