package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main1991 {
    static class Node{
        char data;
        Node left;
        Node right;
        Node(char data){
            this.data = data;
        }
    }
    static class Tree{
        Node root;
        void createNode(char data, char leftData, char rightData){
            if(root == null){
                root = new Node(data);
                if(leftData != '.')
                    root.left = new Node(leftData);
                if(rightData != '.')
                    root.right = new Node(rightData);
            }else{
                searchNode(root, data, leftData, rightData);
            }
        }
        void searchNode(Node root, char data, char leftData, char rightData){
            if(root == null) return;
            else if(root.data == data){
                if(leftData != '.')
                    root.left = new Node(leftData);
                if(rightData != '.')
                    root.right = new Node(rightData);
            }else{
                searchNode(root.left, data, leftData, rightData);
                searchNode(root.right, data, leftData, rightData);
            }
        }
        void pre(Node root){
            System.out.print(root.data);
            if(root.left != null) pre(root.left);
            if(root.right != null) pre(root.right);
        }
        void in(Node root){
            if(root.left != null) in(root.left);
            System.out.print(root.data);
            if(root.right != null) in(root.right);
        }
        void post(Node root){
            if(root.left != null) post(root.left);
            if(root.right != null) post(root.right);
            System.out.print(root.data);
        }
    }
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            tree.createNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }
        tree.pre(tree.root);
        System.out.println();
        tree.in(tree.root);
        System.out.println();
        tree.post(tree.root);
        System.out.println();
    }

}
