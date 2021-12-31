import java.io.*;

public class Main15668 {
    static long N, len, answer;
    public static void main(String[] args) throws Exception {
        input();
        for(int i=1; i<=len; i++){
            func(0, i, new boolean[10], new int[i]);
        }
        System.out.println(answer);
    }
    public static void func(int cnt, int max, boolean[] visited, int[] arr) {
        if(cnt == max){
            StringBuilder sb = new StringBuilder();
            boolean[] checked = new boolean[10];
            for(int a : arr){
                sb.append(a);
                checked[a] = true;
            }
            long result = Long.parseLong(sb.toString());
            if(result < N && 0 < result){
                if(check(result, checked) > 0){
                    System.out.println(result + " + " + (N-result));
                    System.exit(0);
                }
            }
            return;
        }
        for(int i=0; i<=9; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                func(cnt+1, max, visited, arr);
                visited[i] = false;
            }
        }
    }
    public static long check(long result, boolean[] visited){
        long b = N - result;
        while(b/10 > 0){
            int tmp = (int)b%10;
            if(visited[tmp]) return -1;
            visited[tmp] = true;
            b = b/10;
        }
        if(visited[(int)b]) return -1;
        return result;
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        N = Long.parseLong(tmp);
        len = tmp.length();
        answer = -1;
    }
}
