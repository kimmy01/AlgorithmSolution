package com.algo0419;
import java.io.*;
import java.util.*;
public class Solution_SWEA_8382_방향전환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int a = Math.abs(x2 - x1);
            int b = Math.abs(y2 - y1);
            int answer = 0;

            if(a > b){
                answer = 2*b;
                int tmp = a - b;
                if(tmp%2 == 0){
                    answer += 2*tmp;
                }else{
                    answer += 2*tmp - 1;
                }
            }else if(a < b){
                answer = 2*a;
                int tmp = b - a;
                if(tmp%2 == 0){
                    answer += 2*tmp;
                }else{
                    answer += 2*tmp - 1;
                }
            }else if(a == b){
                answer = a+b;
            }

            System.out.println("#"+t+" "+answer);
        }
    }
}
