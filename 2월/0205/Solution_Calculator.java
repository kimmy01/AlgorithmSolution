package day0205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_Calculator {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++ ) {
			
			int N = Integer.parseInt(br.readLine());
			String a = br.readLine();
			
			Stack<Integer> Astack = new Stack<>();
			Stack<Character> Ostack = new Stack<>();
			
			char temp;
			ArrayList<Character> mmm = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer stk = new StringTokenizer(a);
				temp = stk.nextToken().charAt(i);
				if (49 <= temp && temp <= 57) {
					mmm.add(temp);
				} else if(temp == '*') {
					Ostack.push(temp);
				} else if(temp == '+') {
					while(!Ostack.isEmpty()) {
						char check = Ostack.peek();
						mmm.add(Ostack.pop());
					}
					Ostack.push(temp);
				}
			}
			while(!Ostack.isEmpty()) {
				mmm.add(Ostack.pop());
			}
//			//후위표기식 확인
//			for(int i=0; i<N; i++) {
//				System.out.print(mmm.get(i));
//			}
//			System.out.println();
			
			int num2;
			int num1;

			for(int i=0; i<N; i++) {
				temp = mmm.get(i);
				if(49 <= temp && temp <= 57) {
					Astack.push(temp -'0');
				}else if(temp == '+') {
					num2 = Astack.pop();
					num1 = Astack.pop();
					Astack.push(num1+num2);
				}else if(temp == '*') {
					num2 = Astack.pop();
					num1 = Astack.pop();
					Astack.push(num1*num2);
				}
			}
			
			int answer = Astack.pop();
			System.out.println("#"+tc+" "+answer);
			
		}
		
	}

}
