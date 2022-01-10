package com.algo2022_01;

import java.util.*;

public class QueueToStack {
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for(int i=0; i<arr.length; i++){
            push(arr[i]);
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(pop());
        }
    }
    static void push(int num){
        queue1.add(num);
    }
    static int pop(){
        int answer = 0;
        while(queue1.size() > 1){
            queue2.add(queue1.poll());
        }
        answer = queue1.poll();
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return answer;
    }
}
