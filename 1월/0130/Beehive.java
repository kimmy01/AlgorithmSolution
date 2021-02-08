package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beehive {
    /*
    * 1번
    * 2 3 4 5 6 7 6개(2) 1 2 3 4 5 6 -> / ->
    * 8 9 10 11 12 13 14 15 16 17 18 19 12개(3)
    * 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 18개(4)
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);

        int i = 0;
        int k = 1;

        while(true){
            k += i*6;
            if(N<=k){
                System.out.println(i+1);
                break;
            }else{
                i+=1;
            }
        }
    }
}