package day0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_2615_오목 {
	static int[]blackCount;
	static int[]whiteCount;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[19][19];
		int[][] black = new int[180][2];
		int[][] white = new int[180][2];
		int bCnt = 0;
		int wCnt = 0;
		for(int i=0; i<19; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<19; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 1) black[bCnt][0] = i; black[bCnt][1] = j; bCnt++;
				if(map[i][j] == 2) white[wCnt][0] = i; white[wCnt][1] = j; wCnt++;
			}//입력
			Arrays.sort(black, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});//까만돌 정렬
			Arrays.sort(white, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});//흰돌 정렬
			blackCount = new int[bCnt]; //해당 돌로부터 연속된 돌의 개수 체크
			whiteCount = new int[wCnt];
			winner(black, 0, black[0][0], black[0][1]);
			
		}
	}
	static int[] dx = {1, 1, 0}; //하 우하 우
	static int[] dy = {0, 1, 1}; //하 우하 우
	static void winner(int[][]color, int n, int nx, int ny) {
		
	}
}

/* 1. 까만돌부터 체크
 * 2. 까만돌의 첫번째 (제일 왼쪽 돌)부터 가져와서 델타 배열과 더해보고 배열에서 벗어나지 않는지 체크
 * 3. 배열에서 벗어나지 않으면 다음 돌이 1인지 체크
 * 4. 다음 돌이 1이라면 winner(color, n+1, nx+dx[i], ny+dy[i]) 돌리기
 * 5. 다음 돌이 1이 아니라면 continue; (델타 3개 체크하는 거 계속하기)
 * 6. 델타 3개 체크했는데도 다음 돌이 1이 아니라면? blackCount[]에 n값 넣기
 * 7. color의 다음 돌 체크하기, n=0으로 초기화
 * */
