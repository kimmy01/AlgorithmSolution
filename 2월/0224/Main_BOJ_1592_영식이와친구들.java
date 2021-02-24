package com.algo0223;
import java.io.*;
import java.util.*;
public class Main_BOJ_1592_영식이와친구들 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());
        int count = 0;
        int[] people = new int[N+1];
        people[1] = 1;
        int index = 1;
        while(true){
            if(people[index]%2==1){//홀수이면
                if(index+L>N){
                    people[index+L-N]++;
                    count++;
                    index = index+L-N;
                }else{
                    people[index+L]++;
                    count++;
                    index = index+L;
                }
            }else{
                if(index-L<1){
                    people[N+(index-L)]++;
                    count++;
                    index = N+index-L;
                }else{
                    people[index-L]++;
                    count++;
                    index = index-L;
                }
            }
            if(people[index] >= M) break;
        }
        System.out.println(count);
    }
}
