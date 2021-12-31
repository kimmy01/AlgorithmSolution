package day0218;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_1912_연속합 {
	static int N;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(stk.nextToken());
		}
		System.out.println(cal(0, N));
	}
	static int cal(int left, int right) {
		if(left >= right-1) {
			return numbers[left];
		}
		int mid = (left+right)/2;
		int midLeft = 0;
		int maxMidLeft = Integer.MIN_VALUE;
		int midRight = 0;
		int maxMidRight = Integer.MIN_VALUE;
		for(int i=mid-1; i>=left; i--) {
			midLeft += numbers[i];
			maxMidLeft = Math.max(midLeft, maxMidLeft);
		}
		for(int i=mid; i<right; i++) {
			midRight += numbers[i];
			maxMidRight = Math.max(midRight, maxMidRight);
		}
		return Math.max(maxMidLeft+maxMidRight,Math.max(cal(left, mid), cal(mid, right)));
	}
}