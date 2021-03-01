package com.algo02280301;

import java.util.Collections;
import java.util.PriorityQueue;
public class PQ {
    public static void main(String[] args) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        pq.add(4);
        pq.add(10);
        pq.add(3);
        pq.add(2);
        pq.add(1);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}