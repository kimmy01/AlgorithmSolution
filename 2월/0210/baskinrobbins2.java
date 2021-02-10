package com.victoria;

public class baskinrobbins2 {
    static String[] baskinrobbins;
    static String[] selected;
    static int n;
    static int r;
    static int totalCount;
    public static void main(String[] args) {
        baskinrobbins = new String[]{"아몬드봉봉", "민트초콜릿칩", "슈팅스타", "뉴욕치즈케이크", "엄마는외계인", "사랑에빠진딸기"};
        n=6;
        for(int i=1; i<=n; i++){
            selected = new String[i];
            combination(0, 0, i);
        }
    }
    static void combination(int cnt, int start, int r){
        if(cnt == r){
            totalCount++;
            System.out.print("[ ");
            for(int i=0; i<r; i++) {
                System.out.print(selected[i]+" ");
            }
            System.out.println("]");
            return;
        }
        for(int i=start; i<n; i++){
            selected[cnt] = baskinrobbins[i];
            combination(cnt+1, i+1, r);
        }
    }
}
