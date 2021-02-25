package day0225;
import java.io.*;
import java.util.*;
public class Main_BOJ_2304_창고다각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //기둥 개수
		int[] sticks= new int[1001];
		int maxheight = 0;
		int result = 0;
		int maxIndex = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(stk.nextToken());
			int height = Integer.parseInt(stk.nextToken());
			sticks[index] = height;
			if(maxheight < height) {
				maxheight = height;
				maxIndex = index;
			}
		}
		int location = 0; //제일 낮은 기둥 위치부터 시작
		for(int i=0; i<=maxIndex; i++) { //제일 높은 기둥 위치까지 탐색
			if(location<sticks[i]) { //제일 낮은 기둥 위치보다 큰 기둥 찾기
				location = sticks[i]; 
			}
			result+=location;
		}
		location = 0;
		for(int i=1000; i>maxIndex; i--) {
			if(location<sticks[i]) {
				location = sticks[i];
			}
			result+=location;
		}
		System.out.println(result);
	}
}
