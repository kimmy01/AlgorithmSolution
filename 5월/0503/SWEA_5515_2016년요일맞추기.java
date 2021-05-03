package com.algo0502;
import java.util.*;
import java.io.*;
public class SWEA_5515_2016년요일맞추기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int day = 4;

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for(int i=1; i<m; i++){
                if(i==4 || i==6 || i==9 || i==11){
                    day += 30;
                }else if(i==2){
                    day += 29;
                }else{
                    day += 31;
                }
            }

            day += d-1;

            int tmp = day%7;

            System.out.println("#"+t+" "+tmp);
        }
    }
}
