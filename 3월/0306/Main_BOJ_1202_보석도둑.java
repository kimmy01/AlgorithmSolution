package com.algo0305;
import java.io.*;
import java.util.*;

class Gem implements Comparable<Gem>{
    int weight;
    int price;
    public Gem(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Gem o) {
        return this.weight - o.weight;
    }
}

public class Main_BOJ_1202_보석도둑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());//보석개수
        int K = Integer.parseInt(stk.nextToken());//가방개수

        Gem[] gem = new Gem[N];
        int[] bag = new int[K];

        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            gem[i] = new Gem(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }
        for(int i=0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gem);
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0L;
        int index = 0;

        for(int i=0; i<K; i++){
            while(index < N && gem[index].weight <= bag[i]){
                pq.add(gem[index].price);
                index++;
            }
            if(!pq.isEmpty()) sum+=pq.poll();
        }
        System.out.println(sum);
    }
}
