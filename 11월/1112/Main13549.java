import java.util.*;
import java.io.*;

public class Main13549 {
    public static class Point{
        int loc;
        int cnt;
        public Point(int loc, int cnt){
            this.loc = loc;
            this.cnt = cnt;
        }
    }
    static int N, K;
    static int answer = 123456789;
    static int max = 100000;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    public static void func(){
        visited = new boolean[100001];
        bfs();
        System.out.println(answer);
    }
    public static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));
        while(!q.isEmpty()){
            Point p = q.poll();
            visited[p.loc] = true;
            if(p.loc == K){
                answer = Math.min(answer, p.cnt);
            }
            if(p.loc*2 <= max && visited[p.loc*2] == false){ //순간이동
                q.add(new Point(p.loc*2, p.cnt));
            }
            if(p.loc+1 <= max && visited[p.loc+1] == false){ //한 칸 앞으로
                q.add(new Point(p.loc+1, p.cnt+1));
            }
            if(p.loc-1 >= 0 && visited[p.loc-1] == false){ //한 칸 뒤로
                q.add(new Point(p.loc-1, p.cnt+1));
            }
        }
    }
    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
