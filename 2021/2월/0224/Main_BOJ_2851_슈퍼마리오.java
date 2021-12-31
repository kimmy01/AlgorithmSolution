package com.algo0224;
import java.io.*;
public class Main_BOJ_2851_슈퍼마리오 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int mushroom;
        for(int i=0; i<10; i++){
            mushroom = Integer.parseInt(br.readLine());
            if(sum == 100) {
                System.out.println(sum);
                break;
            }else if(sum+mushroom >= 100){
                int tmp1 = sum+mushroom - 100;
                int tmp2 = 100 - sum;
                if(tmp1 == tmp2){
                    System.out.println(sum+mushroom);
                }else if(tmp1 > tmp2){
                    System.out.println(sum);
                }else if(tmp1 < tmp2){
                    System.out.println(sum+mushroom);
                }
                break;
            }else{
                sum+=mushroom;
            }
            if(i==9)System.out.println(sum);
        }
    }
}