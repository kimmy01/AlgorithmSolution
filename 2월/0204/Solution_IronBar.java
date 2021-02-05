package day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_IronBar {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int r=1; r<=tc; r++) {
			char[]ironBar = br.readLine().toCharArray();
			
			Stack<Character> stack = new Stack<>();
			int count = 0;
			
			for(int i=0; i<ironBar.length; i++) {
				
				if(ironBar[i] == '(') {
					stack.push(ironBar[i]);
				}
				else if(ironBar[i] == ')' && ironBar[i-1] == '(') {
					stack.pop();
					count += stack.size();
				}else if(ironBar[i] == ')' && ironBar[i-1] == ')') {
					stack.pop();
					count += 1;
				}
			}
			
			System.out.println("#"+r+" "+count);	
		}	
	}
}
