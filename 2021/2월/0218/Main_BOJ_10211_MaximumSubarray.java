package day0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10211_MaximumSubarray {
	static int  N;
	static int max;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			numbers = new int[N];
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				numbers[i] = Integer.parseInt(stk.nextToken());
			}
			cal();
			System.out.println(max);
		}	
	}
	static void cal() {
		int a = 0;
			for(int j=0; j<N; j++) {
				int res = numbers[j];
				for(int i=j; i<N; i++) {
					if(i==j) {
						max = Math.max(max, res);
					}else {
						res += numbers[i];
						max = Math.max(max, res);
					}
				}
			}
	}
}
