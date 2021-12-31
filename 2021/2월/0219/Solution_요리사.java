package day0219;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_요리사 {
	static int N, min;
	static int[] resA;
	static int[] resB;
	static ArrayList<int[]> synergy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] grocery = new int[N][N];
			StringTokenizer stk;
			for(int i=0; i<N; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					grocery[i][j] = Integer.parseInt(stk.nextToken());
				}
			}//입력
			synergy = new ArrayList<>();
			boolean[][] checked = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!checked[i][j] && i!=j) {
						synergy.add(new int[] {i, j, grocery[i][j]+grocery[j][i]});
						checked[i][j] = true;
						checked[j][i] = true;
					}
				}
			}
			min = Integer.MAX_VALUE;
			resA = new int[N/2];//A
			resB = new int[N/2];//B
			makeComb(0, 0, resA);
			System.out.println("#"+t+" "+min);
		}//TC
	}
	static void makeComb(int n, int k, int[] res) {
		if(k==N/2) {
			boolean[] notSel = new boolean[N];
			for(int i=0; i<N/2; i++) {
				notSel[res[i]] = true;
			}
			int a = 0;
			for(int i=0; i<N; i++) {
				if(!notSel[i]) {
					resB[a] = i;
					a++;
				}
			}
			food();
			return;
		}
		if(n==N)return;
		res[k] = n;
		makeComb(n+1, k+1, res);
		makeComb(n+1, k, res);
	}
	static void food() {
		int A = 0;
		int B = 0;
		for(int i=0; i<resA.length-1; i++) {
			for(int j=i+1; j<resA.length; j++) {
				for(int k=0; k<synergy.size(); k++) {
					if(synergy.get(k)[0] == resA[i] && synergy.get(k)[1] == resA[j]) {
						A+=synergy.get(k)[2];
					}
				}
			}
		} //A음식 시너지
		for(int i=0; i<resB.length-1; i++) {
			for(int j=i+1; j<resB.length; j++) {
				for(int k=0; k<synergy.size(); k++) {
					if(synergy.get(k)[0] == resB[i] && synergy.get(k)[1] == resB[j]) {
						B+=synergy.get(k)[2];
					}
				}
			}
		}//B음식 시너지
		min = Math.min(min, Math.abs(A-B));
	}
}