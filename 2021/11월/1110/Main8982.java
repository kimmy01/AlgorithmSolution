//미해결문제

import java.util.*;
import java.io.*;

public class Main8982 {
    static int N, K;
    static int[][] hole; //구멍난 곳
    static int[][] aquarium; //수족관 꼭지점
    static int[] water; //물 높이 저장
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    public static void func(){
        // 물 높이 저장
        water = new int[aquarium[N-1][0]];
        for(int i=1; i<N-1; i+=2){
            int last = aquarium[i-1][0];
            int height = aquarium[i][1];
            int repeat = aquarium[i+1][0];
            for(int j=last; j<repeat; j++){
                water[j] = height;
            }
        }

        //구멍 높이가 높은 것부터 정렬
        Arrays.sort(hole, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int lastHeight = 0;

        // 구멍 별 물 높이 빼기
        for(int i=0; i<hole.length; i++){
            //빼야 하는 물 높이
            int height = hole[i][1] - lastHeight;
            //해당 공간 빼기
            for(int j=hole[i][0]; j<hole[i][2]; j++){
                if(water[j] >= height){
                    water[j] -= height;
                }
            }

            int leftX = hole[i][0];
            int rightX = hole[i][2];

            right(rightX, hole[i][1], height);
            left(leftX, hole[i][1], height);
        }

        int answer = 0;
        for(int i=0; i<water.length; i++){
            System.out.println(water[i]);
            answer += water[i];
        }
        System.out.println(answer);
    }
    public static void right(int rightX, int holeHeight, int minusHeight){
        while(true){
            rightX++;
            if(rightX < water.length){ //범위 체크
                if(aquarium[rightX][1] >= holeHeight){ //벽인지 아닌지
                    if(water[rightX] >= minusHeight){
                        water[rightX] -= minusHeight;
                    }
                }else{
                    return;
                }
            }
            return;
        }
    }
    public static void left(int leftX, int holeHeight, int minusHeight){
        while(true){
            leftX-=2;
            if(leftX >= 0){ //범위 체크
                if(aquarium[leftX][1] >= holeHeight){ //벽인지 아닌지
                    if(water[leftX] >= minusHeight){
                        water[leftX] -= minusHeight;
                    }
                }else{
                    return;
                }
            }
            return;
        }
    }
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        aquarium = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            aquarium[i][0] = stoi(st.nextToken());
            aquarium[i][1] = stoi(st.nextToken());
        }
        K = stoi(br.readLine());
        hole = new int[K][4];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            hole[i][0] = stoi(st.nextToken());
            hole[i][1] = stoi(st.nextToken());
            hole[i][2] = stoi(st.nextToken());
            hole[i][3] = stoi(st.nextToken());
        }
    }
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
