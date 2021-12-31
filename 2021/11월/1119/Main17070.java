import java.util.*;
import java.io.*;
public class Main17070 {
    static int N;
    static int count;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func(){
        count = 0;
        move(1, 2, 0);
        System.out.println(count);
    }
    private static void move(int x, int y, int dir) {
        if(x == N && y == N && map[x][y] != 1) { //NXN 도착
            count++;
            return;
        }
        if(dir == 0) { // 현재 가로
            if(isValid(x, y+1)) move(x, y+1, 0); //가로로 밀기
            if(isValid(x, y+1) && isValid(x+1, y+1) && isValid(x+1, y)) move(x+1, y+1, 2); //대각선으로 밀기
        } else if(dir == 1) { //현재 세로
            if(isValid(x+1, y)) move(x+1, y, 1); //세로로 밀기
            if(isValid(x, y+1) && isValid(x+1, y+1) && isValid(x+1, y)) move(x+1, y+1, 2); //대각선으로 밀기
        } else if(dir == 2) { //현재 대각선
            if(isValid(x, y+1)) move(x, y+1, 0); //가로로 밀기
            if(isValid(x+1, y)) move(x+1, y, 1); //세로로 밀기
            if(isValid(x, y+1) && isValid(x+1, y+1) && isValid(x+1, y)) move(x+1, y+1, 2); //대각선으로 밀기
        }
    }
    private static boolean isValid(int x, int y) {
        if(x > 0 && y > 0 && x <= N && y <= N && map[x][y] == 0) return true;
        return false;
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st = null;
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }
    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
