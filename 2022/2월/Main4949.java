package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main4949 {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<list.size(); j++){
            String s = list.get(j);
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(' || c == '['){
                    stack.push(c);
                }else if(c == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }else if(c == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.isEmpty()){
                sb.append("yes");
            }else {
                sb.append("no");
            }
            if(j == list.size()-1) continue;
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String tmp = br.readLine();
            if(tmp.equals(".")) break;
            list.add(tmp);
        }
    }
}
