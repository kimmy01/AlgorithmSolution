package day0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2961_도영이가만든맛있는음식 {
	static int[] sour;
	static int[] bitter;
	static boolean[] checked;
	static int mul, sum, answer, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		checked = new boolean[N];
		mul = 1;
		sum = 0;
		answer = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(stk.nextToken());
			bitter[i] = Integer.parseInt(stk.nextToken());
		}//값 넣기
		cook(0, mul, sum);
		System.out.println(answer);
	}
	static void cook(int count, int mul, int sum) {
		if(count == N) {
			int temp = Math.abs(mul-sum);
			if(answer > temp && sum!=0) {
				answer = temp;
			}
			return;
		}
		checked[count] = true;
		cook(count+1, mul*sour[count], sum+bitter[count]);
		checked[count] = false;
		cook(count+1, mul, sum);
	}
}
