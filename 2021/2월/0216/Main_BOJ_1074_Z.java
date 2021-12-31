package day0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z {
	static int[][] map;
	static int n;
	static int N;
	static int r;
	static int c;
	static int input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		n = (int) Math.pow(2, N);
		z(n, 0, 0);
	}
	
	static void z(int n, int x, int y) {
		if(x == r && y == c) {
			System.out.println(input);
			return;
		}
		
		if(x<=r && r<(x+n) && y<=c && c<(y+n)) {
			int next = n/2;
			z(next, x, y); //0,0
			z(next, x, y+next); //0,1
			z(next, x+next, y); //1,0
			z(next, x+next, y+next); //1,1
		}else {
			input += n*n;
		}
	}
}