package com.algo03020303;
import java.io.*;
import java.util.*;
public class Main_BOJ_10773_제로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                stack.pop();
            } else {
                stack.push(temp);
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        System.out.println(sum);
    }
}