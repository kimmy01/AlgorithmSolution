package com.algo0319;
import java.util.*;
import java.io.*;
public class Main_BOJ_9177_단어섞기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=1; i<=N; i++){
            Deque<Character> firstWord = new LinkedList<>();
            Deque<Character> secondWord = new LinkedList<>();
            Deque<Character> thirdWord = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            String temp = st.nextToken();
            for(int k=0; k<temp.length(); k++){
                firstWord.addLast(temp.charAt(k));
            }
            temp = st.nextToken();
            for(int k=0; k<temp.length(); k++){
                secondWord.addLast(temp.charAt(k));
            }
            temp = st.nextToken();
            for(int k=0; k<temp.length(); k++){
                thirdWord.addLast(temp.charAt(k));
            }
            int flag = 0;
            while(!thirdWord.isEmpty()){
                if(firstWord.isEmpty()){
                    flag = 1;
                    break;
                }
                if(secondWord.isEmpty()){
                    flag = 2;
                    break;
                }
                char a = thirdWord.poll();
                if(a == firstWord.peek() && a == secondWord.peek()){
                    
                }
                if(a == firstWord.peek()){
                    firstWord.poll();
                }else if(a == secondWord.peek()){
                    secondWord.poll();
                }else if(a != secondWord.peek() && a != firstWord.peek()){
                    sb.append("Data set "+i+": no"+"\n");
                    flag = 4;
                    break;
                }
            }
            if(flag == 1){
                while(!thirdWord.isEmpty()){
                    char b = thirdWord.poll();
                    if(secondWord.peek() != b){
                        sb.append("Data set "+i+": no"+"\n");
                        flag = 4;
                        break;
                    }
                    secondWord.poll();
                }
            }
            if(flag == 2){
                while(!thirdWord.isEmpty()){
                    char b = thirdWord.poll();
                    if(firstWord.peek() != b){
                        sb.append("Data set "+i+": no"+"\n");
                        flag = 4;
                        break;
                    }
                    firstWord.poll();
                }
            }
            if(flag != 4){
                sb.append("Data set "+i+": yes"+"\n");
            }
        }
        System.out.println(sb);
    }
}
