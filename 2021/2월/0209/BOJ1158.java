package day0209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1158 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer stk = new StringTokenizer(s, " ");
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		LinkedList<Integer> queue1 = new LinkedList<>();
		LinkedList<Integer> queue2 = new LinkedList<>();
		LinkedList<Integer> queueA = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			queue1.add(i);
		}
		
		while(queue1.size() >= K) {
			for(int i=1; i<K; i++) {
				int a = queue1.poll();
				queue2.add(a);
			}
			queueA.add(queue1.poll()); //K번째를 정답 큐에 넣기
			for(int i=1; i<K; i++) {
				int b = queue2.poll();
				queue1.add(b);
			}
		}
		while(true) {
			if(queueA.size() == N) {
				break;
			}else {
				for(int i=1; i<K; i++) {
					if(!queue1.isEmpty()) {
						queue2.add(queue1.poll());
					}else if(queue1.isEmpty()) {
						while(!queue2.isEmpty()) {
							queue1.add(queue2.poll());
						}
						queue2.add(queue1.poll());
					}
				}
				if(queue1.isEmpty()) {
					queueA.add(queue2.poll());
				}else {
					queueA.add(queue1.poll());
				}
			}
		}
		
		bw.write("<");
		for(int i=0; i<N-1; i++) {
			int c = queueA.poll();
			bw.write(String.valueOf(c)+", ");
		}
		bw.write(String.valueOf(queueA.poll())+">");
		bw.flush();
		
	}
}
