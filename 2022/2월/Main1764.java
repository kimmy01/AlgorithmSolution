package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> Nset = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0; i<N; i++){
            Nset.add(br.readLine());
        }
        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            if(Nset.contains(tmp)){
                arrayList.add(tmp);
            }
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }
}
