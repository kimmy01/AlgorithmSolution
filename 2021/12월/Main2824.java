package com.algo12;

import java.util.*;
import java.io.*;

public class Main2824 {
    static int N, M, max;
    static int[] Nnumbers;
    static int[] Mnumbers;
    static ArrayList<Boolean> primeNumbers;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        eratosthenes();
        HashMap<Integer, Integer> Nmap = primeFactorization(Nnumbers, N);
        HashMap<Integer, Integer> Mmap = primeFactorization(Mnumbers, M);
        Long answer = getGC(Nmap, Mmap);
        if(answer > 999999999){
            String tmp = answer.toString();
            System.out.println(tmp.substring(tmp.length()-9));
        }else{
            System.out.println(answer);
        }
    }
    static Long getGC(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        if(map1.size() == 0 || map2.size() == 0) return 1L;
        Long gc = 1L;
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            int tmp = entry.getKey();
            int e = 0;
            if(map2.containsKey(tmp)){
                int a = entry.getValue();
                int b = map2.get(tmp);
                e = Math.min(a, b);
            }
            for(int i=0; i<e; i++){
                gc *= tmp;
            }
        }
        return gc;
    }
    static HashMap<Integer, Integer> primeFactorization(int[] numbers, int limit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=2; i<primeNumbers.size(); i++){
            if(!primeNumbers.get(i)) continue;
            for(int j=0; j<limit; j++){
                if(numbers[j] == 1) continue;
                if(numbers[j] < i) continue;
                while(numbers[j] % i == 0){
                    if(map.containsKey(i)){
                        map.replace(i, map.get(i)+1);
                    }else{
                        map.put(i, 1);
                    }
                    numbers[j] = numbers[j]/i;
                }
            }
        }
        return map;
    }
    static void eratosthenes() {
        primeNumbers = new ArrayList<>(max+1);
        primeNumbers.add(false);
        primeNumbers.add(false);
        for(int i=2; i<=max; i++){
            primeNumbers.add(i, true);
        }
        for(int i=2; (i*i) <= max; i++){
            if(primeNumbers.get(i)){
                for(int j=i*i; j<=max; j+=i){
                    primeNumbers.set(j, false);
                }
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Nnumbers = new int[N];
        max = 0;
        for(int i=0; i<N; i++){
            Nnumbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, Nnumbers[i]);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Mnumbers = new int[M];
        for(int i=0; i<M; i++){
            Mnumbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, Mnumbers[i]);
        }
    }
}
