package day0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//class Node{
//	int number;
//	String operation;
//	int lChild = 0;
//	int rChild = 0;
//}


public class Solution_tree1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int answer = 1;
			int n = Integer.parseInt(br.readLine());
//			Node[] node = new Node[n+1];
			StringTokenizer stk;
			for(int i=1; i<=n; i++) {
				String a = br.readLine();
				stk = new StringTokenizer(a, " ");
				stk.nextToken();
				char op = stk.nextToken().charAt(0);
				if(op == '+' || op == '*' || op == '/' || op == '-') {
					if(stk.countTokens() != 4) {
						answer = 0;
					}
				}
				
			}
//				if(stk.countTokens()==4){
//					int abc = Integer.parseInt(stk.nextToken());
//					node[i].number = abc;
//					node[i].operation = stk.nextToken();
//					node[i].lChild = Integer.parseInt(stk.nextToken());
//					node[i].rChild = Integer.parseInt(stk.nextToken());
//					System.out.println(node[i].number);
//				}else if(stk.countTokens()==3) {
//					node[i].number = Integer.parseInt(stk.nextToken());
//					node[i].operation = stk.nextToken();
//					node[i].lChild = Integer.parseInt(stk.nextToken());
//				}else if(stk.countTokens()==2) {
//					node[i].number = Integer.parseInt(stk.nextToken());
//					node[i].operation = stk.nextToken();
//				}
//			}
//			int flag = 1;
//			int index = 1;
//			while(index <= n) {
//				char op = node[index].operation.charAt(0);
//				if(op >= 15) { //피연산자
//					char opL = node[node[index].lChild].operation.charAt(0);
//					char opR = node[node[index].rChild].operation.charAt(0);
//					if(opL != 15 || opR != 15) {
//						flag = 0;
//					}
//				} 
//				index++;
//			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}
}
