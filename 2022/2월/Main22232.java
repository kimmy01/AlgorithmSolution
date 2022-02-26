package com.algo2022_02;

import java.io.*;
import java.util.*;

public class Main22232 {
    static class File{
        String fileName;
        String extension;
        File(String fileName, String extension){
            this.fileName = fileName;
            this.extension = extension;
        }
    }
    static int N, M;
    static HashSet<String> extensionSet = new HashSet<>();
    static ArrayList<File> fileList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            String fileName = tmp.split("\\.")[0];
            String extension = tmp.split("\\.")[1];
            File file = new File(fileName, extension);
            fileList.add(file);
        }
        for(int i=0; i<M; i++){
            extensionSet.add(br.readLine());
        }
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(o1.fileName.equals(o2.fileName)){
                    if((extensionSet.contains(o1.extension) && extensionSet.contains(o2.extension)) || (!extensionSet.contains(o1.extension) && !extensionSet.contains(o2.extension))){
                        return o1.extension.compareTo(o2.extension);
                    }else if(extensionSet.contains(o1.extension)){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                return o1.fileName.compareTo(o2.fileName);
            }
        });
        for(File f : fileList){
            System.out.println(f.fileName+"."+f.extension);
        }
    }
}
