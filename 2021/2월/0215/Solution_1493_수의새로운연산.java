package day0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493_수의새로운연산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			int[][] arr = new int[300][300];
			int input = 1;
			int px = 0;
			int py = 0;
			int qx = 0;
			int qy = 0;
			int answer;
				for(int j=1; j<300; j++) {
					int temp = j;
					for(int i=1; i<=j; i++) {
						if(input == p) {
							px = i;
							py = temp;
						}
						if(input == q) {
							qx = i;
							qy = temp;
						}
						arr[i][temp] = input;
						input++;
						temp--;
					}
				}
				System.out.println(px+" "+py+" "+qx+" "+qy);
				answer = arr[px+qx][py+qy];
				System.out.println("#"+t+" "+answer);
		}
	}
}
