package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Bulk {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];
        int[] cp;
        LinkedList<int[]> queue = new LinkedList<int[]>();

        for(int i=0; i<N; i++){
            String a = br.readLine();
            StringTokenizer stk = new StringTokenizer(a, " ");
            weight[i] = Integer.parseInt(stk.nextToken());
            height[i] = Integer.parseInt(stk.nextToken());
            queue.offer(new int[] {weight[i], height[i]});
        }//입력받기

        int j=0;
        while(!queue.isEmpty()){
            cp = queue.poll();
            for(int i=0; i<N; i++) {
                if (cp[0] < weight[i] && cp[1] < height[i]) {
                    rank[j]++;
                }
            }
            j++;
        }

        for(int i=0; i<N; i++) {
            System.out.print((rank[i]+1)+" ");
        }
    }
}
