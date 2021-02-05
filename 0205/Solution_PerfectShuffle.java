package day0205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_PerfectShuffle {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		LinkedList<String> queue1 = new LinkedList<String>();
		LinkedList<String> queue2 = new LinkedList<String>();
		LinkedList<String> queue3 = new LinkedList<String>();
		
		for(int n = 1; n <= tc; n++) {
			
			queue1.clear();
			queue2.clear();
			queue3.clear();
			
			int N = Integer.parseInt(br.readLine());
			String cards = br.readLine();
			StringTokenizer stk = new StringTokenizer(cards, " ");
			
			for(int i=0; i<N; i++) {
				queue1.add(stk.nextToken());
			}
			
			String temp;
			int rp = N/2; //반복횟수
			
			if(N%2==0) {
				while(rp>0){
					temp = queue1.poll();
					queue2.add(temp);
					rp--;
				}
				rp = N/2;
				while(rp>0){
					temp = queue1.poll();
					queue3.add(temp);
					rp--;
				}
			}else {
				while(rp>0){
					temp = queue1.poll();
					queue2.add(temp);
					rp--;
				}
				temp = queue1.poll();
				queue2.add(temp);
				
				rp=N/2;
				while(rp>0){
					temp = queue1.poll();
					queue3.add(temp);
					rp--;
				}
			}
			
			
			while(queue1.size() < N) {
				temp = queue2.poll();
				queue1.add(temp);
				temp = queue3.poll();
				queue1.add(temp);
			}
			
			
			System.out.print("#"+n+" ");
			
			for(int i=0; i<N; i++) {
				System.out.print(queue1.poll()+" ");
			}
			
			System.out.println();
		}

	}

}
