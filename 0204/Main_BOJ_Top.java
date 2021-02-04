package day0204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_Top {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[N+1];
		int[] top = new int[N+1];
		
		String line = br.readLine();
		StringTokenizer stk = new StringTokenizer(line, " ");
		
		for(int i=1; i<=N; i++) {
			top[i] = Integer.parseInt(stk.nextToken());
			ans[i] = 0;
		} //입력받기
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stackIdx = new Stack<>();

		for(int i=1; i<=N; i++) {

					while(true) {
						
						if(!stack.empty()) {
							
							if(top[i] < stack.peek()) {//현재 탑의 높이가 스택 최상단 값보다 작다면?
								ans[i] = stackIdx.peek();
								stack.push(top[i]);
								stackIdx.push(i);
								break;
							}else {
									stack.pop();
									stackIdx.pop();
							}
							
						}else {
							stack.push(top[i]);
							stackIdx.push(i);
							break;
						}	
					}
				}
		
		for(int i=1; i<=N; i++) {
			bw.write(String.valueOf(ans[i]));
			if(i<N) {
				bw.write(" ");
			}
			
			bw.flush();
		}
	}

}
