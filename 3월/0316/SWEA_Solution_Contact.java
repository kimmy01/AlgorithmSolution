package day0316;
import java.util.*;
import java.io.*;
public class SWEA_Solution_Contact {
	static int[][] map;
	static int[] visit;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			Queue<Integer> queue = new LinkedList<>();
			queue.add(b);
			map = new int[101][101];
			visit = new int[101];
			visit[b] = -1;
			max = 0;
			StringTokenizer stk2 = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<a/2; i++) {
				int from = Integer.parseInt(stk2.nextToken());
				int to = Integer.parseInt(stk2.nextToken());
				map[from][to] = 1;
			}
			while(!queue.isEmpty()) {
				max = 0;
				int size = queue.size();
				for(int k=0; k<size; k++) {
					int search = queue.poll();
					if(max<search) max = search;
					for(int j=1; j<=100; j++) {
						if(map[search][j] == 1 && visit[j]!=-1) {
							visit[j] = -1;
							queue.add(j);
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
