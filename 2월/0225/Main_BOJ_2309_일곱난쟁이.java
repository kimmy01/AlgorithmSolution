package day0225;
import java.io.*;
import java.util.*;
public class Main_BOJ_2309_일곱난쟁이 {
	static int[] dwarf = new int[7];
	static int[] men;
	static int flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		men = new int[9];
		flag = 0;
		for(int i=0; i<9; i++) {
			men[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(men);
		Comb(0, 0, 0);
	}
	
	static void Comb(int cnt, int start, int height) {
		if(flag == 1) return;
		if(cnt == 7) {
			if(height == 100) {
				for(int i=0; i<7; i++) {
					System.out.println(dwarf[i]);
				}
				flag = 1;
			}
			return;
		}
		for(int i=start; i<9; i++) {
			dwarf[cnt] = men[i];
			Comb(cnt+1, i+1, height+dwarf[cnt]);
		}
	}
}
