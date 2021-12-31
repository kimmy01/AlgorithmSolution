import java.util.*;
import java.io.*;
public class Main12906 {
    static class Node {
        Stack<Character>[] stick;
        public Node(){
            this.stick = new Stack[3];
            for(int i=0; i<3; i++){
                this.stick[i] = new Stack<>();
            }
        }
        public String status(){
            String result = "";
            for(char c : this.stick[0]) result += c;
            result += '|';
            for(char c : this.stick[1]) result += c;
            result += '|';
            for(char c : this.stick[2]) result += c;
            return result;
        }
    }

    static HashSet<String> hashSet;
    static Queue<Node> queue;
    static String answer;
    static Node start = new Node();
    static Node end = new Node();

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        queue.add(start);
        hashSet.add(start.status()); //초기 상태 저장
        System.out.println(bfs());
    }

    private static int bfs() {
        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Node current = queue.poll();

                if(current.status().equals(answer)){ //답과 같으면 리턴
//                    System.out.println(count + " : " + current.status());
                    return count;
                }

                for(int from=0; from<2; from++){
                    for(int to=0; to<3; to++){
                        if(!current.stick[from].isEmpty()){ //현재 스틱에 원판이 있으면
                            Node next = copy(current);

                            next.stick[to].push(next.stick[from].pop());
                            String status = next.status();

                            if(!hashSet.contains(status)){
                                hashSet.add(status);
                                queue.add(next);
//                                System.out.println(count + " : " + next.status());
                            }
                        }
                        if(!current.stick[to].isEmpty()){
                            Node next = copy(current);

                            next.stick[from].push(next.stick[to].pop());
                            String status = next.status();
                            if(!hashSet.contains(status)){
                                hashSet.add(status);
                                queue.add(next);
//                                System.out.println(count + " : " + next.status());
                            }
                        }
                    }
                }
            } //큐 사이즈만큼 탐색 후 count 증가
            count++;
        }
        return count;
    }

    private static Node copy(Node oldNode) { //현재 노드 복사
        Node newNode = new Node();

        for(int i=0; i<3; i++){
            for(char ch : oldNode.stick[i]){
                newNode.stick[i].push(ch);
            }
        }
        return newNode;
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hashSet = new HashSet<>();
        queue = new LinkedList<>();

        int a = 0; int b = 0; int c = 0; //완성된 하노이탑의 모양 만들기 위해서 원판 개수 카운트

        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) continue;
            String disc = st.nextToken();
            for(int j=0; j<N; j++){
                char ch = disc.charAt(j);
                if(ch == 'A') a++;
                if(ch == 'B') b++;
                if(ch == 'C') c++;
                start.stick[i].push(ch);
            }
        }

        for(int i=0; i<a; i++){
            end.stick[0].push('A');
        }
        for(int i=0; i<b; i++){
            end.stick[1].push('B');
        }
        for(int i=0; i<c; i++){
            end.stick[2].push('C');
        }
        answer = end.status();
    }
}
