package day0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_snail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int num;
		int[][] snail;
		
		for(int i=1; i<=tc; i++) {
			int input = 1;
			num = Integer.parseInt(br.readLine());
			snail = new int[num][num];
			int N = num;
			int a = 0; int b = -1;
			
			while(input<=num*num) {
				for(int j=0; j<N; j++) {
					snail[a][++b]=input;
					input++;
				}
				
				N--;
				
				for(int j=0; j<N; j++) {
					snail[++a][b]=input;
					input++;
				}
				
				for(int j=0; j<N; j++) {
					snail[a][--b]=input;
					input++;
				}
				
				N--;
				
				for(int j=0; j<N; j++) {
					snail[--a][b]=input;
					input++;
				}
			}

			System.out.println("#"+i);
			for(int m=0; m<num; m++) {
				for(int n=0; n<num; n++) {
					System.out.print(snail[m][n]+" ");
				}
				System.out.println();
			}
		}
		
	}
}
