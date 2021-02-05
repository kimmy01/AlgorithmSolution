package day0203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Farm {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			int start = N/2;
			int finish = N/2;
			int M = N/2;
			int hap = 0;
			char[] farmary;
			int d;
			
			for(int i=0; i<N; i++) {
				farmary = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					farm[i][j] = (int)farmary[j]-48;
				}
		
			}	
			
			for( int i =0; i< M; i++) {
				for (int j = start; j<=finish; j++) {
					hap += farm[i][j];	
				}
				start -=1;
				finish +=1;
			}

			for(int i=M; i<N; i++) {
				for(int j = start; j<=finish; j++) {
					hap += farm[i][j];
				}
				start +=1;
				finish -=1;
			}
			System.out.println("#"+tc +" "+hap);
		
		}
	}

}
