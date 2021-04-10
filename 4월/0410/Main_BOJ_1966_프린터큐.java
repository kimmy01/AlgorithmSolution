package com.algo0410;
import java.util.*;
import java.io.*;
public class Main_BOJ_1966_프린터큐 {
    static class Paper{
        int index;
        int rate;
        public Paper(int index, int rate){
            this.index = index;
            this.rate = rate;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); //순서 궁금한 문서의 현재 위치
            Queue<Paper> papers = new LinkedList<>();
            Queue<Paper> papers2 = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            Integer[] rating = new Integer[N];
            for(int i=0; i<N; i++){
                int rate = Integer.parseInt(st.nextToken());
                papers.add(new Paper(i, rate));
                rating[i] = rate;
            }
            Arrays.sort(rating, Collections.reverseOrder());
            for(int i=0; i<N; i++){
                while(true){
                    Paper temp = papers.poll();
                    if(rating[i] == temp.rate) {
                        papers2.add(temp);
                        break;
                    }
                    papers.add(temp);
                }
            }
            for(int i=0; i<N; i++){
                Paper temp = papers2.poll();
                if(temp.index == M) {
                    System.out.println(i+1);
                }
            }
        }
    }
}
