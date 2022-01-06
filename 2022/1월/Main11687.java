import java.io.*;

public class Main11687 {
    static int M, left, right, mid, answer, tmp;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        while(left <= right){
            mid = (left+right)/2;
            answer = 0;
            tmp = mid;
            while(tmp >= 5){
                answer += tmp/5;
                if(answer > M) break;
                tmp /= 5;
            }
            if(answer < M){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        answer = 0;
        tmp = left;
        while(tmp >= 5){
            answer += tmp/5;
            tmp /= 5;
        }
        if(answer == M){
            System.out.println(left);
        }else{
            System.out.println(-1);
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        left = 1;
        right = M*5;
    }
}