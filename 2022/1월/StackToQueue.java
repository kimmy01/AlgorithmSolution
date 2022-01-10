package com.algo2022_01;

import java.util.*;

public class StackToQueue {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for(int i=0; i<arr.length; i++){
            add(arr[i]);
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(poll());
        }
    }
    static int poll(){
        int num = 0;
        while(stack1.size() > 1){
            stack2.push(stack1.pop());
        }
        num = stack1.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return num;
    }
    static void add(int num){
        stack1.push(num);
    }
}
