package com.algo2022_01;

import java.util.LinkedList;
import java.util.Queue;

public class NTS_LiveCoding3 {
    public static void main(String[] args) {

    }
    public static void calculate(String input){
        Queue<Integer> numberQueue = new LinkedList<>();
        Queue<Character> operatorQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(Character.isDigit(c)){
                sb.append(c);
            }else{
                int num = Integer.parseInt(sb.toString());
                numberQueue.add(num);
                operatorQueue.add(c);
                sb = new StringBuilder();
            }
        }
        numberQueue.add(Integer.parseInt(sb.toString()));

    }
}
