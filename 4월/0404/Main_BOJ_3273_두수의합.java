package com.algo0404;
import java.util.*;
import java.io.*;
public class Main_BOJ_3273_두수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int i = 0; int j = N-1; int count = 0;
        while(i<j){
            if(numbers[i]+numbers[j] == x){
                count++;
                i++;
                j--;
            }else if(numbers[i]+numbers[j] < x){
                i++;
            }else if(numbers[i]+numbers[j] > x){
                j--;
            }
        }
        System.out.println(count);
    }
}
