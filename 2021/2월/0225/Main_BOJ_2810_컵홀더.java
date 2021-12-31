package day0225;
import java.io.*;
import java.util.*;
public class Main_BOJ_2810_컵홀더 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Character>stack = new Stack<>();
		String a = br.readLine();
		int coupleCnt = 0;
		for(int i=0; i<N; i++) {
			char temp = a.charAt(i);
			if(temp == 'S') {
				stack.push('*');
				stack.push(temp);
			}else if(temp == 'L') {
				if(coupleCnt%2==0) {
					stack.push('*');
					stack.push(temp);
					coupleCnt++;
				}else {
					stack.push(temp);
					coupleCnt++;
				}
			}
		}
		stack.push('*');
		int people = 0;
		while(!stack.isEmpty()) {
			char cup = stack.pop();
			if(cup == '*') {
				people++;
			}
		}
		if(people>N) {
			System.out.println(N);
		}else {
			System.out.println(people);
		}
	}
}


