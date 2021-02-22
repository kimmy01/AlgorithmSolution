package com.algo0222;
import java.io.*;
import java.util.*;
public class Main_BOJ_3052_나머지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];
        ArrayList<Integer> num = new ArrayList<>();
        int count = 0;
        for(int i=0; i<10; i++){
            int N = Integer.parseInt(br.readLine());
            if(num.contains(N%42)){
                continue;
            }
            num.add(N%42);
            count++;
        }
        System.out.println(count);
    }
}