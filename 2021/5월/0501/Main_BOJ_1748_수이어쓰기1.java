package com.algo0502;
import java.io.*;
public class Main_BOJ_1748_수이어쓰기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] a = new int[9];
        int[] b = new int[10];

        a[1] = 9;
        a[2] = 99-10+1;
        a[3] = 999-100+1;
        a[4] = 9999-1000+1;
        a[5] = 99999-10000+1;
        a[6] = 999999-100000+1;
        a[7] = 9999999-1000000+1;
        a[8] = 99999999-10000000+1;

        b[1] = 0;
        b[2] = 10;
        b[3] = 100;
        b[4] = 1000;
        b[5] = 10000;
        b[6] = 100000;
        b[7] = 1000000;
        b[8] = 10000000;
        b[9] = 100000000;

        int Nlength = N.length();
        int answer = 0;
        for(int i=0; i<Nlength; i++){
            answer += a[i]*i;
        }
        answer += (Integer.parseInt(N) - b[Nlength] + 1)*Nlength;
        if(Nlength == 1){
            System.out.println(answer-1);
        }else{
            System.out.println(answer);
        }
    }
}
