import java.util.*;
import java.io.*;
public class Main16437 {
    static int N, island; //목적 섬
    static long[] number; //동물 수
    static char[] animal; //동물 종류
    static ArrayList<Integer>[] tree; //섬 연결관계

    public static void main(String[] args) throws Exception {
        input();
        long answer = func(1);
        System.out.println(answer);
    }
    public static long func(int node) {
        long sum = 0;
        for(int nextNode : tree[node]){ //자식노드 탐색
            sum += func(nextNode);
        }
        if(animal[node] == 'S'){ //양일 때
            return sum += number[node];
        }else{ //늑대일 때
            if(sum - number[node] >= 0){
                return sum - number[node];
            }else{
                return 0;
            }
        }
    }
    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st;

        tree = new ArrayList[N+1];
        animal = new char[N+1];
        number = new long[N+1];

        for(int i=0; i<N+1; i++){ //트리 초기화
            tree[i] = new ArrayList<>();
        }

        for(int i=2; i<N+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            animal[i] = st.nextToken().charAt(0); //동물 종류
            number[i] = stol(st.nextToken()); //동물 수
            island = stoi(st.nextToken()); //목적지 섬
            tree[island].add(i);
        }
    }
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static long stol(String s){
        return Long.parseLong(s);
    }
}
