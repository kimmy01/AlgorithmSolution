package day0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a = N/3;
		int answer = -1;
		for(int i=0; i<=a; i++) {
			for(int j=0; j<=a; j++) {
				if(3*j+5*i == N) {
					answer = i+j;
					break;
				}
			}
		}
		System.out.println(answer);	
	}
}