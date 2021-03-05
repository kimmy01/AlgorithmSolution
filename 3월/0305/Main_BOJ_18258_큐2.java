package com.algo0305;
import java.io.*;
import java.util.*;
public class Main_BOJ_18258_큐2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
//        ArrayList<Integer> arr = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<N; i++){
            String temp = br.readLine();
            if(temp.contains("push")){
                StringTokenizer stk = new StringTokenizer(temp, " ");
                stk.nextToken();
//                arr.add(Integer.parseInt(stk.nextToken()));
                deque.add(Integer.parseInt(stk.nextToken()));
            }else{
                if(temp.equals("pop")){
//                    if(!arr.isEmpty()){
//                        bw.write(String.valueOf(arr.get(0))+"\n");
//                        arr.remove(0);
//                    }else{
//                        bw.write(String.valueOf(-1)+"\n");
//                    }
                    if(!deque.isEmpty()){
                        bw.write(String.valueOf(deque.pollFirst())+"\n");
                    }else{
                        bw.write(String.valueOf(-1)+"\n");
                    }
                }else if(temp.equals("size")){
//                    bw.write(String.valueOf(arr.size())+"\n");
                    bw.write(String.valueOf(deque.size())+"\n");
                }else if(temp.equals("empty")){
//                    if(arr.isEmpty()){
//                        bw.write(String.valueOf(1)+"\n");
//                    }else{
//                        bw.write(String.valueOf(0)+"\n");
//                    }
                    if(deque.isEmpty()){
                        bw.write(String.valueOf(1)+"\n");
                    }else{
                        bw.write(String.valueOf(0)+"\n");
                    }
                }else if(temp.equals("front")){
//                    if(!arr.isEmpty()){
//                        bw.write(String.valueOf(arr.get(0))+"\n");
//                    }else{
//                        bw.write(String.valueOf(-1)+"\n");
//                    }
                    if(!deque.isEmpty()){
                        bw.write(String.valueOf(deque.peekFirst())+"\n");
                    }else{
                        bw.write(String.valueOf(-1)+"\n");
                    }
                }else if(temp.equals("back")){
//                    if(!arr.isEmpty()){
//                        bw.write(String.valueOf(arr.get(arr.size()-1))+"\n");
//                    }else{
//                        bw.write(String.valueOf(-1)+"\n");
//                    }
                    if(!deque.isEmpty()){
                        bw.write(String.valueOf(deque.peekLast()+"\n"));
                    }else{
                        bw.write(String.valueOf(-1)+"\n");
                    }
                }
            }
        }
        bw.flush();
    }
}
