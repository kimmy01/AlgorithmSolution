package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main3663 {
    static int N, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            cnt = 0;
            String word = br.readLine();
            cnt += change(word);
            System.out.println(calcDistance(word) + cnt);
        }
    }
    static int calcDistance(String word){
        int[] array = new int[4];
        //1. 기존방향
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) != 'A') array[0] = i;
        }
        //2. 역방향
        for(int i=word.length()-1; i>0; i--){ //ABBBAB
            if(word.charAt(i) != 'A') array[1] = word.length() - i;
        }
        //3. 기존+역
        int min = 123456789;
        for(int k=0; k<word.length(); k++){
            array[2] = 0;
            for(int i=0; i<k; i++){
                if(word.charAt(i) != 'A') array[2] = i;
            }
            array[2] *= 2;
            int tmp = 0;
            for(int i=word.length()-1; i>=k; i--){
                if(word.charAt(i) != 'A') tmp = word.length() - i;
            }
            array[2] += tmp;
            min = Math.min(min, array[2]);
        }
        array[2] = min;
        //4. 역+기존
        min = 123456789;
        for(int k=0; k<word.length(); k++){
            array[3] = 0;
            for(int i=word.length()-1; i>=k; i--){ //ABBAAAABABBABA
                if(word.charAt(i) != 'A') array[3] = word.length() - i;
            }
            array[3] *= 2;
            int tmp = 0;
            for(int i=0; i<k; i++){
                if(word.charAt(i) != 'A') tmp = i;
            }
            array[3] += tmp;
            min = Math.min(min, array[3]);
        }
        array[3] = min;
        Arrays.sort(array);
//        for(int a : array){
//            System.out.println(a);
//        }
        return array[0];
    }
    static int change(String word){
        int cnt = 0;
        for(int i=0; i<word.length(); i++){
            if('A' != word.charAt(i)){
                int dif = word.charAt(i) - 'A';
                if(dif > 13) cnt += 'Z' - word.charAt(i) + 1;
                else cnt += dif;
            }
        }
        return cnt;
    }
}
