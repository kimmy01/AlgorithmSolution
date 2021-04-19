package com.algo0419;
import java.io.*;
import java.util.*;
public class Main_BOJ_1708_볼록껍질 {
    static class Vertex{
        long x;
        long y;
        public Vertex(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static Vertex root = new Vertex(Long.MAX_VALUE, Long.MAX_VALUE);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Vertex> vertexList = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            vertexList.add(new Vertex(x, y));
        }
        int answer = grahamScan(vertexList);
        System.out.println(answer);
    }
    static int grahamScan(ArrayList<Vertex> list){
        //점들의 집합에서 y좌표가 가장 작거나, y좌표가 같으면 x좌표가 가장 작은 점 찾기
        for(int i=0; i<list.size(); i++){
            if(list.get(i).y < root.y){
                root = list.get(i);
            }else if(list.get(i).y == root.y){
                if(list.get(i).x < root.x){
                    root = list.get(i);
                }
            }
        }
        list.sort(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) { // return 1 => 자리 변경
                int result = CCW(root, o1, o2);
                if(result > 0){ //반시계 방향(좌회전)
                    return -1;
                }else if(result < 0){ //시계 방향(우회전)
                    return 1;
                }else{ //각도가 같을 경우에는 거리로 판단 (거리가 더 멀면 후순위)
                    long distance1 = Distance(root, o1);
                    long distance2 = Distance(root, o2);
                    if(distance1 > distance2){
                        return 1;
                    }
                }
                return -1;
            }
        });

        Stack<Vertex> stack = new Stack<>();
        stack.add(root);
        for(int i=1; i<list.size(); i++){
            //스택에 2개 이상의 점이 있고
            // 가장 최근 push된 두 점을 이은 직선 기준으로 새로운 점이 왼쪽에 있다면 push
            //오른쪽에 있다면 스택의 가장 위에 있는 점을 pop
            while(stack.size() > 1 &&
                    (CCW(stack.get(stack.size()-2), stack.get(stack.size()-1), list.get(i)) <= 0)){
                stack.pop();
            }
            stack.add(list.get(i));
        }
        return stack.size();
    }
    //점 v1, v2, v3을 순서대로 보았을 때, 반시계방향으로 놓여 있으면 양수, 시계방향으로 놓여 있으면 음수, 평행하게 놓여 있으면 0
    static int CCW(Vertex v1, Vertex v2, Vertex v3){
        long result = (v2.x - v1.x)*(v3.y - v1.y) - (v3.x - v1.x)*(v2.y - v1.y);
        if(result > 0){ //반시계
            return 1;
        }else if(result < 0){ //시계
            return -1;
        }else{
            return 0;
        }
    }
    static long Distance(Vertex v1, Vertex v2){
        return (v2.x - v1.x)*(v2.x - v1.x) + (v2.y - v1.y)*(v2.y - v1.y);
    }
}
