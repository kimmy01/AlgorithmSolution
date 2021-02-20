package com.algo02200221;

import java.io.*;
import java.util.Stack;

public class Main_BOJ_17413_단어뒤집기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        Stack<Character> words = new Stack<>();
        int index = 0;
        while(index < S.length()){
            char temp = S.charAt(index);
            if (temp == '<') {
                while(!words.isEmpty()){
                    sb.append(words.pop());
                }
                sb.append(temp);
                index++;
                while (true) {
                    char tempTag = S.charAt(index);
                    if(tempTag != '>'){
                        sb.append(tempTag);
                        index++;
                    }else{
                        sb.append(tempTag);
                        index++;
                        break;
                    }
                }
            }else{
                if(temp == ' '){
                    while(!words.isEmpty()){
                        char a = words.pop();
                        sb.append(a);
                    }
                    sb.append(temp);
                    index++;
                }else{
                    words.push(temp);
                    index++;
                }
            }
        }
        while(!words.isEmpty()){
            sb.append(words.pop());
        }
        System.out.println(sb);

    }
}
