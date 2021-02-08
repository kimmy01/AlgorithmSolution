package day0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SpotMart {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=1; i<=tc; i++) {
			String s = br.readLine();
			StringTokenizer stk = new StringTokenizer(s, " ");
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int[] snacks = new int[N];
			s = br.readLine();
			stk = new StringTokenizer(s, " ");
			for(int j=0; j<N; j++) {
				snacks[j] = Integer.parseInt(stk.nextToken());
			}
			int answer = -1;
			int max = 0;
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					if(a != b) {
						if(snacks[a]+snacks[b] <= M && snacks[a]+snacks[b] > max)
						max = snacks[a]+snacks[b];
					}
				}
			}
			if(max != 0) {
				answer = max;
			}
			System.out.println("#"+i+" "+answer);		
		}
	}
}
