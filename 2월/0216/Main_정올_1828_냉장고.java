package day0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] substance = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			substance[i][0] = Integer.parseInt(stk.nextToken());
			substance[i][1] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(substance, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		});
		
		int standard2 = substance[0][1];//최고기준
		int count = 1;
		
		for(int i=1; i<N; i++) {
			if(substance[i][0] > standard2) {
				count++;
				standard2 = substance[i][1];
			}else {
				if(substance[i][1] < standard2) {
					standard2 = substance[i][1];
				}
			}
		}
		System.out.println(count);
	}
}
