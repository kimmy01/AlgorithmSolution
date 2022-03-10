package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main2263 {
    static int N;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] postOrder;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        postOrder = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            map.put(a, i);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        findRoot(0, N-1, 0, N-1);
    }
    static void findRoot(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return;
        System.out.print(postOrder[postEnd]+" ");
        int idx = map.get(postOrder[postEnd]); //inOrder에서 위치
        int left = idx - inStart;
        findRoot(inStart, idx-1, postStart, postStart+left-1);
        findRoot(idx+1, inEnd, postStart+left, postEnd-1);
    }
}
