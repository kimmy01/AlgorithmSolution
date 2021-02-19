package day0219;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	static int N, count;
	static int[] weight, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			result = new int[N];
			count = 0;
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(stk.nextToken());
			}
			Permutation(0, new boolean[N]);
			System.out.println("#"+t+" "+count);
		}
	}
	static void makeSubset(int n, int cnt, boolean[] selected, int leftWeight, int rightWeight) {
		if(leftWeight < rightWeight) return;
		if(n==N) {
			count++;
			return;
		}
		selected[n] = true;
		makeSubset(n+1, cnt+1, selected, leftWeight+result[n], rightWeight);
		selected[n] = false;
		makeSubset(n+1, cnt, selected, leftWeight, rightWeight+result[n]);
	}

	static void Permutation(int n, boolean[]visited) {
		if(n==N) {
			makeSubset(0, 0, new boolean[N], 0, 0);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[n] = weight[i];
				Permutation(n+1, visited);
				visited[i] = false;
			}
		}
	}
}