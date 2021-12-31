package com.algo0409;
import java.io.*;
import java.util.*;
public class Main_BOJ_10800_컬러볼 {
    static class Ball implements Comparable<Ball>{
        int index;
        int color;
        int size;
        int hap;
        Ball(int index, int color, int size, int hap){
            this.index = index;
            this.color = color;
            this.size = size;
            this.hap = hap;
        }

        @Override
        public int compareTo(Ball ball) {
            return ball.size - this.size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Ball> balls = new ArrayList<>();
        int[] colors = new int[N+1];
        int total = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            colors[color] += size; //해당 색깔 공의 사이즈 더하기
            total += size; //전체 공 사이즈 더하기
            balls.add(new Ball(i, color, size, 0)); //현재 공 추가
        }
        Collections.sort(balls); //사이즈 내림차순 정렬
        for(int i=0; i<N; i++){
            Ball big = balls.get(i);
            for(int j=i+1; j<N; j++){
                Ball temp = balls.get(j);
                if(temp.size < big.size) break;
                if(temp.color != big.color) balls.get(i).hap -= temp.size;
            }
            balls.get(i).hap += total - colors[big.color];
            total -= big.size;
            colors[big.color] -= big.size;
        }

        Collections.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.index - o2.index;
            }
        });

        for(int i=0; i<N; i++){
            System.out.println(balls.get(i).hap);
        }

//      Ball[] balls = new Ball[N];
//        for(int i=0; i<N; i++){
//            st = new StringTokenizer(br.readLine(), " ");
//            balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
//        }
//        Arrays.sort(balls);
//
//        for(int i=0; i<N; i++){
//            for(int j=i+1; j<N; j++){
//                if(balls[i].color != balls[j].color) {
//                    balls[i].hap+=balls[j].size;
//                }
//            }
//        }
//        Arrays.sort(balls, new Comparator<Ball>() {
//            @Override
//            public int compare(Ball o1, Ball o2) {
//                return o1.index - o2.index;
//            }
//        });
//        for(int i=0; i<N; i++){
//            System.out.println(balls[i].hap);
//        }
    }
}
