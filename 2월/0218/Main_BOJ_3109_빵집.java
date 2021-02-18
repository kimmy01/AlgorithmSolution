package day0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집 {
	static int R, C, max, count;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		max = Integer.MIN_VALUE;
		count = 0;
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}//입력
		pipe(0,0,0);
		System.out.println(max);
	}
	static int[] dx = {1, 1, 1}; //우상 우 우하
	static int[] dy = {-1, 0, 1};//우상 우 우하
	/* 1. (x,0)에서 시작해서 다음에 갈 곳이 인덱스에서 벗어나는지 확인
	 * 2. 다음에 갈 곳이 X면 return .이면 가보기
	 * 3. 반복하다가 (x,C-1)에 도달하면 count++ 하고 (x+1,0)에서 시작하는 거 부르기
	 * */
	static void pipe(int y, int x, int start) {
		if(x==C-1) { //열의 끝에 도달했을 때
			count++; //카운트++
			if(start==R-1) { //이번 턴 시작이 행의 끝이었다면
				max = Math.max(max, count); //카운트와 max카운트 비교하기
				count = 0; //카운트 초기화
				return;
			}else {
				start++; //다음행에서 시작하는 기 위해 증가시킴
				pipe(start, 0, start); //다음행 시작시키기
			}
		}
		int flag = 0;
		for(int i=0; i<3; i++) { //다음칸으로 이동가능한지?
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx && nx<C && 0<=ny && ny<R) {
				if(map[ny][nx] == 'x') { //다음칸이 x이면
					continue;
				}else {
					if(start+1<=R-1) {
						pipe(ny, nx, start);
						flag = 1; //다음칸으로 이동한다는 것 의미
					}
				}
			}
		}
		if(flag == 0 && start+1 <= R-1) {//다음칸으로 이동 불가하면서 다음 행이 배열 인덱스 벗어나지 않는다면
			start++;
			pipe(start, 0, start); //다음행에서 시작하도록 호출
		}
	}
}