package day0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_HamburgerDiet {
	static boolean[] isSelected;
	static int[] score;
	static int[] kcal;
	static int highscore;
	static int N;
	static int L;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String NL = br.readLine();
			StringTokenizer stk = new StringTokenizer(NL, " ");
			N = Integer.parseInt(stk.nextToken());
			L = Integer.parseInt(stk.nextToken());
			isSelected = new boolean[N];
			score = new int[N];
			kcal = new int[N];
			highscore = 0;
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				stk = new StringTokenizer(s, " ");
				score[i] = Integer.parseInt(stk.nextToken());
				kcal[i] = Integer.parseInt(stk.nextToken());
			}
			calculating(0);
			System.out.println("#"+tc+" "+highscore);
		}
	}
	
	static void calculating(int count) {
		if(count == N) {
			int scoresum = 0;
			int kcalsum = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					scoresum += score[i];
					kcalsum += kcal[i];
				}
			}
			if(kcalsum <= L && highscore < scoresum) {
				highscore = scoresum;
			}
			return;
		}
		isSelected[count] = true;
		calculating(count+1);
		isSelected[count] = false;
		calculating(count+1);
	}

}
