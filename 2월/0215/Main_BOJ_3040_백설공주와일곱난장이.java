package day0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_3040_백설공주와일곱난장이 {
	static int[] dwarf;
	static int[] selected;
	static boolean[] checked;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		selected = new int[7];
		checked = new boolean[9];
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
	}
	static void comb(int n, int k) {
		int sum = 0;
		if(k == 7) {
			for(int i=0; i<7; i++) {
				sum += selected[i];
			}
			if(sum == 100) {
				print();
				return;
			}else {
				return;
			}
		}
		
		for(int i=n; n<9; n++) {
			selected[k] = dwarf[n];
			comb(n+1, k+1);
		}	
	}
	
	static void print() {
		for(int i=0; i<selected.length; i++) {
			System.out.println(selected[i]);
		}
	}
}
