package day0204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_Bracket {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			char[] bracket = line.toCharArray();
			int answer=0;

			Stack<Character>stack = new Stack<>();
				
			for(int i=0; i<N; i++) {
				
				if(!stack.isEmpty()) {
					char before = stack.peek();
					if(before == '{' && bracket[i] == '}') {
						stack.pop();
					}
					else if(before == '[' && bracket[i] == ']') {
						stack.pop();
					}
					
					else if(before == '(' && bracket[i] == ')') {
						stack.pop();
					}
					
					else if(before == '<' && bracket[i] == '>') {
						stack.pop();
						
					}else {
						stack.push(bracket[i]);
					}
					
				}else {
					stack.push(bracket[i]);
				}
			}
			
			if(stack.isEmpty()) {
				answer = 1;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
