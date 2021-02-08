package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_RCcar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); //테케
        for(int t=1; t<=tc; t++){
            int N = Integer.parseInt(br.readLine()); //테케 별 커맨드 수
            int distance = 0;
            int vel = 0;
            int pom = 0;
            for(int i=0; i<N; i++){
                String a = br.readLine();
                if(a.length() > 1){
                    StringTokenizer stk = new StringTokenizer(a, " ");
                    pom = Integer.parseInt(stk.nextToken()); //가/감
                    int inVel = Integer.parseInt(stk.nextToken()); //속도
                    if(pom == 1){
                        vel += inVel;
                        distance += vel;
                    }else if(pom == 2){
                        if(vel-inVel < 0){
                            vel = 0;
                        }else {
                            vel -= inVel;
                        }
                        distance += vel;
                    }
                }else{
                    distance += vel;
                }
            }
            System.out.println("#"+t+" "+distance);
        }
    }
}
