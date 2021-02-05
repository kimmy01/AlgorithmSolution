package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decomposition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            if(num(i) == N){
                System.out.println(i);
                break;
            }else if((i==N) && num(i)!=N){
                System.out.println("0");
            }
        }
    }
    static int num(int a){
        int answer = a;
        while(a>0){
            answer += a%10;
            a /= 10;
        }
        return answer;
    }
}

