package day0316;
import java.util.*;
import java.io.*;
public class Main_BOJ_1759_암호만들기 {
	static int L, C;
	static char[] alphabet;
	static char[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		alphabet = new char[C];
		selected = new char[L];
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			alphabet[i] = stk.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		Comb(0, 0);
	}
	static void Comb(int cnt, int start) {
		if(cnt == L) {
			int vowelCnt = 0;
			for(int i=0; i<L; i++) {
				if(selected[i]=='a' || selected[i]=='e' || selected[i]=='i' || selected[i]=='o' || selected[i]=='u') {
					vowelCnt++;
				}
			}
			if(1<=vowelCnt && vowelCnt<=L-2) {
				for(int i=0; i<L; i++) {
					System.out.print(selected[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i=start; i<C; i++) {
				selected[cnt] = alphabet[i];
				Comb(cnt+1, i+1);
		}
		
	}
}
