package day0225;
import java.io.*;
import java.util.*;
public class Main_BOJ_2578_빙고 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[5][5];
		StringTokenizer stk;
		for(int i=0; i<5; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<5; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				q.add(Integer.parseInt(stk.nextToken()));
			}
		}
		
		int count = 0;
		while(true) {
			int temp = q.poll();
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(map[i][j] == temp) {
						map[i][j] = -1;
						count++;
						break;
					}
				}
			}
			int line = 0;
			for(int i=0; i<5; i++) {
				if(map[i][0] == -1 && map[i][1] == -1 && map[i][2] == -1 && map[i][3] == -1 && map[i][4] == -1) {
					line++;
				}
				if(map[0][i] == -1 && map[1][i] == -1 && map[2][i] == -1 && map[3][i] == -1 && map[4][i] == -1) {
					line++;
				}
			}
			if(map[2][2] == -1) {
				if(map[0][0] == -1 && map[1][1] == -1 && map[2][2] == -1 && map[3][3] == -1 && map[4][4] == -1) {
					line++;
				}
				if(map[4][0] == -1 && map[3][1] == -1 && map[2][2] == -1 && map[1][3] == -1 && map[0][4] == -1) {
					line++;
				}
			}
			if(line >= 3) {
				break;
			}
		}
		
		System.out.println(count);
		
	}
}
