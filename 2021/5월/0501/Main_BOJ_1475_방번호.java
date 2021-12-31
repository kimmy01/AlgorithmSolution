package com.algo0501;
import java.io.*;
public class Main_BOJ_1475_방번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int[] num = new int[9];

        for(int i=0; i<number.length(); i++){
            int a = number.charAt(i) - '0';
            if(a == 9){
                num[6]++;
                continue;
            }
            num[a]++;
        }

        int maxNum = 0;
        int max = 0;

        for(int i=0; i<num.length; i++){
            if(max < num[i]) {
                maxNum = i;
                max = num[i];
            }
        }

        if(maxNum == 6){
            if(max%2 == 0){
                max = max/2;
            }else{
                max = max/2 + 1;
            }
        }

        System.out.println(max);

    }
}
