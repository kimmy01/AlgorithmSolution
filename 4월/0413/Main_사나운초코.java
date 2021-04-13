package com.algo0413;
import java.util.*;
import java.io.*;
//public class Main_사나운초코 {
//    static int N, K;
//    static int[] dogs;
//    static int[] selected;
//    static ArrayList<Integer> list;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        dogs = new int[N];
//        selected = new int[K];
//        list = new ArrayList<>();
//        for(int i=0; i<N; i++){
//            dogs[i] = Integer.parseInt(br.readLine());
//        }
//        Arrays.sort(dogs);
//        selected[0] = dogs[0];
//        selected[K-1] = dogs[N-1];
//        comb(1, 1);
//        Collections.sort(list);
//        System.out.println(list.get(list.size()-1));
//    }
//    static void comb(int start, int cnt){
//        if(cnt == K-1){
//            int min = 123456789;
//            for(int i=0; i<K-1; i++){
//                int distance = selected[i+1] - selected[i];
//                min = Math.min(distance, min);
//            }
//            list.add(min);
//            return;
//        }
//        for(int i=start; i<N-1; i++){
//            selected[cnt] = dogs[i];
//            comb(i+1, cnt+1);
//        }
//    }
//}
public class Main_사나운초코 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        int answer = 1;
        int start = 1; //가능한 거리의 시작 값
        int end = a[N-1]-a[0]; //가능한 거리의 마지막 값
        while(start <= end){
            int mid = (start+end)/2;
            if(check(a, mid, K)){
                answer = Math.max(answer, mid);
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
    static boolean check(int[] a, int distance, int K){
        int cnt = 1;
        int last = a[0]+distance;
        for(int i=0; i<a.length; i++){
            if(a[i] >= last){
                cnt++;
                last = a[i]+distance;
            }
        }
        return cnt >= K;
    }
}