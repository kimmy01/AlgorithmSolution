package day0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳 {
	static int R, C, answer;
	static char[][] alphabet;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1}; //상하좌우
	static boolean[][] visited;
	static boolean[] checked;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		alphabet = new char[R][C];
		checked = new boolean[26];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			alphabet[i] = input.toCharArray();
		}
		func(0,0,1);
		System.out.println(answer);
	}
	
	static void func(int r, int c, int cnt) {
		answer = Math.max(answer, cnt);
		visited[r][c] = true;
		checked[alphabet[r][c]-'A'] = true;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(0<=nr && nr<R && 0<=nc && nc<C && !visited[nr][nc]) {
				if(!checked[alphabet[nr][nc]-'A']) {
					func(nr, nc, cnt+1);
					visited[nr][nc] = false;
					checked[alphabet[nr][nc]-'A'] = false;
				}
			}
		}
	}
}
