import java.util.*;
import java.io.*;
public class Main2170 {
    static int N, answer;
    static int[][] point;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    public static void func(){
        answer = 0;
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = point[0][0];
        int end = point[0][1];
        for(int i=1; i<N; i++){
            if(point[i][0] <= end && point[i][1] > end){
                end = point[i][1];
            }else if(point[i][0] <= end && point[i][1] <= end){
                continue;
            }else{
                answer += end - start;
                start = point[i][0];
                end = point[i][1];
            }
        }
        answer += end - start;
        System.out.println(answer);
    }
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        point = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = stoi(st.nextToken());
            point[i][1] = stoi(st.nextToken());
        }
    }
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
