package day0203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_flies {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; t
				c<=T; tc++) {
			String s = br.readLine();
			StringTokenizer stk = new StringTokenizer(s);
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int[][] array = new int[N][N]; 
			String ary;
			
			int best=0;
			
			for(int i=0; i<N; i++) {
				ary = br.readLine();
				stk = new StringTokenizer(ary, " ");
				for(int j=0; j<N; j++) {
					String abc = stk.nextToken();
					array[i][j] = Integer.parseInt(abc);
				}
			}	//배열에 담기
			
			for(int i=0; i<(N-M+1); i++) { //순회 가능한 x좌표
				for(int j=0; j<(N-M+1); j++) {//순회 가능한 y좌표
					
					int hap=0;

					for(int k=i; k<i+M; k++) {//순회하는 x좌표
						for(int m=j; m<j+M; m++) {//순회하는 y좌표
							hap += array[k][m];
							int K = array[k][m];
						}
					}
					
//					for(int k=0; k<M; k++) {
//						for(int m=0; m<M; m++) {
//							hap+= array[i+k][j+m];
//						}
//					}
					
					if(hap > best) {
						best = hap;
					}
				}
			}
			
			System.out.println("#"+tc+" "+best);
		}
	}
}
