package day0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	public static void main(String[] args) throws Exception {
		int[][] whitePaper = new int[100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			String a = br.readLine();
			StringTokenizer stk = new StringTokenizer(a, " ");
			int y = Integer.parseInt(stk.nextToken());
			int x = Integer.parseInt(stk.nextToken());
			
			for(int k=0; k<10; k++) {
				for(int j=0; j>-10; j--) {
					whitePaper[99-x+j][y+k] = 1;
				}
			}
		}
		int blackCount = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(whitePaper[i][j] == 1) {
					blackCount++;
				}
			}
		}
		System.out.println(blackCount);
	}
}
