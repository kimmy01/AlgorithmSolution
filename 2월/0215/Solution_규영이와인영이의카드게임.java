package day0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_규영이와인영이의카드게임 {
	static boolean[] cards;
	static boolean[] checked;
	static int[] kyu;
	static int[] in;
	static int answer, cnt, meancnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			answer = cnt = meancnt = 0;
			checked = new boolean[9];
			kyu = new int[9];
			in = new int[9];
			cards = new boolean[19];
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				kyu[i] = Integer.parseInt(stk.nextToken());
				cards[kyu[i]] = true;
			}
			int temp = 0;
			for(int i=1; i<=18; i++) {
				if(cards[i]==false) {
					in[temp] = i;
					temp++;
				}
			}
			games(0, 0, 0);
			int lose = cnt - answer - meancnt;
			System.out.println("#"+t+" "+answer+" "+lose);
		}
	}
	static void games(int round, int kyu_sum, int in_sum) {
		if(round==9) {
			cnt++;
			if(kyu_sum>in_sum) answer++;
			if(kyu_sum==in_sum) meancnt++;
			return;
		}
		for(int i=0; i<9; i++) {
			int win = kyu[round]+in[i];
			if(checked[i]==false) {
				checked[i]=true;
				if(kyu[round]>in[i]) {
					games(round+1, kyu_sum+win, in_sum);
				}else {
					games(round+1, kyu_sum, in_sum+win);
				}
				checked[i]=false;
			}
		}
	}
}