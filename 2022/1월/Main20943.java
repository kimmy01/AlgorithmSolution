package com.algo2022_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main20943 {
    static int N, vertical;
    static HashMap<Double, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        long number = N*(N-1)/2;
        number -= vertical*(vertical-1)/2;
        for(Map.Entry<Double, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            number -= value*(value-1)/2;
        }
        System.out.println(number);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        vertical = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            if(b == 0){
                vertical += 1;
                continue;
            }
            double d = -a/b;
            if(map.containsKey(d)){
                int count = map.get(d);
                map.replace(d, count+1);
            }else{
                map.put(d, 1);
            }
        }
    }
}
