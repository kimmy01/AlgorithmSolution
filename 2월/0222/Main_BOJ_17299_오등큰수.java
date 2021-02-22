package com.algo0222;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main_BOJ_17299_오등큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stacks = new Stack<>();
        int[] list = new int[N];
        int[] num = new int[1000001];
        int[] NGF2 = new int[N];
        int count = 0;
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(stk.nextToken());
            num[list[i]]++;
        }
        for (int k = N-1; k >= 0; k--) {
            while (!stacks.isEmpty() && num[list[k]] >= num[stacks.peek()])
                stacks.pop();

            if (stacks.isEmpty())
                NGF2[k] = -1;
            else
                NGF2[k] = stacks.peek();

            stacks.push(list[k]);
        }
        for(int j=0; j<N; j++){
            sb.append(NGF2[j]+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}