import java.util.*;
import java.io.*;

public class Main17616 { //백준 등수찾기

    static int N, M, X, A, B, cnt, U, V;
    static ArrayList<Integer>[] upper;
    static ArrayList<Integer>[] lower;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();
        func();
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        X = stoi(st.nextToken());
        upper = new ArrayList[N+1];
        lower = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            upper[i] = new ArrayList<>();
            lower[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            A = stoi(st.nextToken()); //더 높
            B = stoi(st.nextToken()); //더 낮
            lower[A].add(B);
            upper[B].add(A);
        }
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
    public static void func() {
        //높은 등수
        cnt = 0;
        visited = new boolean[N+1];
        visited[X] = true;
        recursion(X, upper);
        U = 1+cnt;

        //낮은 등수
        cnt = 0;
        visited = new boolean[N+1];
        visited[X] = true;
        recursion(X, lower);
        V = N-cnt;

        System.out.println(U+" "+V);
    }
    public static void recursion(int a, ArrayList<Integer>[] list) {
        for(int i = 0; i<list[a].size(); i++){
            if(!visited[list[a].get(i)]){
                visited[list[a].get(i)] = true;
                cnt++;
                recursion(list[a].get(i), list);
            }
        }
    }
}
