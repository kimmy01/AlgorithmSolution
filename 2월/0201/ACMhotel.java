package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACMhotel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int T = Integer.parseInt(t);

        for(int i=0; i<T; i++){
            String cases = br.readLine();
            StringTokenizer stk = new StringTokenizer(cases);
            int H = Integer.parseInt(stk.nextToken());
            int W = Integer.parseInt(stk.nextToken());
            int N = Integer.parseInt(stk.nextToken());
            int floor = 0;
            int num = 0;
            int room = 0;

            if(N%H != 0){//번호/층 = 나머지가 0이 아닐 때
                if(N/H == 0){//번호/층 = 몫이 0일 때
                    floor = N*100;
                    num = 1;
                    room = floor+num;
                }else{
                    floor = (N%H)*100;
                    num = N/H+1;
                    room = floor+num;
                }
            }else{//번호/층 = 나머지가 0일 때
                floor = H*100;
                num = N/H;
                room = floor+num;
            }

            if(num<10){
                System.out.println(room);
            }else{
                System.out.println(room);
            }
        }
    }
}
