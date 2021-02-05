package com.ssafy;

import java.util.Scanner;

public class BaseStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int AnswerN = 0;
        int N;

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            char[][] map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String currentLine = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = currentLine.charAt(j);
                }
            }

//            int[] A = {-1, 0, 1}; ->
//              int[] di = {-1, 1, 0, 0};
//              int[] dj = {0, 0, -1, 1};
//            int[] B = {-2, -1, 0, 1, 2};
//            int[] C = {-3, -2, -1, 0, 1, 2, 3};

            for(int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if(map[i][j]!='X' && map[i][j]!='H'){ //기지국 찾음
                        int cover = map[i][j] - 'A'+1;
                        for(int c = 1; c <= cover; c++){
                            if(i-c>=0&&map[i-c][j]=='H'){//up
                                map[i-c][j] = 'X';
                            }
                            if(i+c>=0&&map[i+c][j]=='H'){//down
                                map[i+c][j] = 'X';
                            }
                            if(j-c>=0&&map[i][j-c]=='H'){//left
                                map[i][j-c] = 'X';
                            }
                            if(j+c>=0&&map[i][j+c]=='H'){//right
                                map[i][j+c] = 'X';
                            }
                        }
                    }

                }
            }
            //아래 예시는 대각선까지 커버하는 것
//                    if(map[i][j] == 'A'){
//                        for(int a = 0; a<A.length; a++){
//                            for(int b = 0; b<A.length; b++){
//                                if(0 <= i+A[a] && i+A[a] < N && 0 <= j+A[b] && j+A[b] < N){
//                                    if(map[i+A[a]][j+A[b]]=='H'){
//                                        map[i+A[a]][j+A[b]]='X';
//                                    }
//                                }
//                            }
//                        }

//                    }else if(map[i][j] == 'B'){
//
//                        for(int a = 0; a<B.length; a++){
//                            for(int b = 0; b<B.length; b++){
//                                if(0 <= i+B[a] && i+B[a] < N && 0 <= j+B[b] && j+B[b] < N){
//                                    if(map[i+B[a]][j+B[b]]=='H'){
//                                        map[i+B[a]][j+B[b]]='X';
//                                    }
//                                }
//                            }
//                        }
//
//                    }else if(map[i][j] == 'C'){
//
//                        for(int a = 0; a<C.length; a++){
//                            for(int b = 0; b<C.length; b++){
//                                if(0 <= i+C[a] && i+C[a] < N && 0 <= j+C[b] && j+C[b] < N){
//                                    if(map[i+C[a]][j+C[b]]=='H'){
//                                        map[i+C[a]][j+C[b]]='X';
//                                    }
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }

            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map.length; j++) {
                    System.out.print(map[i][j]);
                    if(map[i][j] == 'H') {
                        AnswerN++;
                    }
                }
                System.out.println();
            }
            System.out.println("#" + test_case + " " + AnswerN);
        }
    }

}
//테케
//        1
//        9
//        XXXXXXXXX
//        XXXHXXXXX
//        XXHAHXXHX
//        XXHHXXXXX
//        XXXXXXXXX
//        XXAHHXXXX
//        XXHXXHAHX
//        XXAHXXHXX
//        XXHXHXXXX
//        XXXXXXXXX
//
//        1
//        9
//        XXXXXXXXX
//        XXXHXXXXX
//        XXHAHHXHX
//        XXHHXXXXX
//        XXXXXXXXX
//        XXBHHXXXX
//        XXHXXHCHH
//        XXAHXXHXX
//        XXHXHXXXX
//        XXXXXXXXX