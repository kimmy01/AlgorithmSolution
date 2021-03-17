package com.algo0317;
import java.util.*;
import java.io.*;
public class Main_BOJ_4195_친구네트워크 {
    static int[] parent;
    static int[] level;
    static HashMap<String, Integer> friends;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            friends = new HashMap<>();
            int F = Integer.parseInt(br.readLine());
            int index = 1;

            parent = new int[F*2];
            level = new int[F*2];
            for (int i = 0; i < F*2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!friends.containsKey(a)) {
                    friends.put(a, index);
                    index++;
                }
                if (!friends.containsKey(b)) {
                    friends.put(b, index);
                    index++;
                }
                int num = union(friends.get(a), friends.get(b));
                sb.append(num + "\n");
            }
//                union(person[0], person[1]);
//                sb.append(friendsCount(person[1])+"\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
            level[x] += level[y];
        }
        return level[x];
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
//    static void union(String a, String b){
//        int a_idx = friends.get(a);
//        int b_idx = friends.get(b);
//        if(a_idx<b_idx){
//            setFriends(b_idx, a_idx);
//        }else{
//            setFriends(a_idx, b_idx);
//        }
//    }
//    static int friendsCount(String s){
//        int cnt = 0;
//        int idx = friends.get(s);
//        Set set = friends.keySet();
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            String key = (String) iterator.next();
//            if(idx == friends.get(key)){
//                cnt++;
//            }
//        }
//        return cnt;
//    }
//    static void setFriends(int big_idx, int small_idx){
//        Set set = friends.keySet();
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            String key = (String) iterator.next();
//            if(big_idx == friends.get(key)){
//                friends.put(key, small_idx);
//            }
//        }
//    }
//}