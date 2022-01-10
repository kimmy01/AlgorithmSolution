package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main14725 {
    static int N;
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[K];
            StringBuffer sb = new StringBuffer();
            for(int j=1; j<=K; j++){
                String s = st.nextToken();
                sb.append(s);
                arr[j-1] = s.length();
            }
            trie.insert(sb.toString(), arr);
        }
        trie.print();
    }
    static class TrieNode{
        private Map<String, TrieNode> childNodes = new TreeMap<>();
        private boolean isLast;
        Map<String, TrieNode> getChildNodes() {
            return this.childNodes;
        }
        void setIsLast(boolean isLast){
            this.isLast = isLast;
        }
    }
    static class Trie{
        TrieNode rootNode;
        Trie(){
            rootNode = new TrieNode();
        }
        public void insert(String word, int[] arr){
            TrieNode thisNode = rootNode;
            int idx = 0;
            for(int i=0; i<arr.length; i++){
                String str = word.substring(idx, idx+arr[i]);
                idx += arr[i];
                thisNode = thisNode.getChildNodes().computeIfAbsent(str, key -> new TrieNode());
            }
            thisNode.setIsLast(true);
        }
        public void print(){
            print(rootNode, 0);
        }
        public void print(TrieNode thisNode, int floor){
            Set<String> set = thisNode.getChildNodes().keySet();
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                String str = it.next();
                TrieNode childNode = thisNode.childNodes.get(str);
                for(int i=0; i<floor; i++){
                    System.out.print("--");
                }
                System.out.println(str);
                print(childNode, floor+1);
            }
        }
    }
}
