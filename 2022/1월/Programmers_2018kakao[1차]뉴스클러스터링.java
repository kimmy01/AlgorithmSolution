import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        HashMap<String, Integer> hashMap = new HashMap<>(); // str1 str2
        HashMap<String, Integer> hashMap1 = new HashMap<>(); // str1
        HashMap<String, Integer> hashMap2 = new HashMap<>(); // str2
        
        //ascii 65~90
        for(int i=0; i<str1.length()-1; i++){
            String tmp = str1.substring(i, i+2);
            if(65 <= tmp.charAt(0) && tmp.charAt(0) <= 90 && 65 <= tmp.charAt(1) && tmp.charAt(1) <= 90){
                if(hashMap.containsKey(tmp)){
                    int v = hashMap.get(tmp);
                    hashMap.put(tmp, v+1);
                }else{
                    hashMap.put(tmp, 1);
                }
                if(hashMap1.containsKey(tmp)){
                    int v = hashMap1.get(tmp);
                    hashMap1.put(tmp, v+1);
                }else{
                    hashMap1.put(tmp, 1);
                }
            }
        }
         for(int i=0; i<str2.length()-1; i++){
            String tmp = str2.substring(i, i+2);
            if(65 <= tmp.charAt(0) && tmp.charAt(0) <= 90 && 65 <= tmp.charAt(1) && tmp.charAt(1) <= 90){
                if(hashMap.containsKey(tmp)){
                    int v = hashMap.get(tmp);
                    hashMap.put(tmp, v+1);
                }else{
                    hashMap.put(tmp, 1);
                }
                if(hashMap2.containsKey(tmp)){
                    int v = hashMap2.get(tmp);
                    hashMap2.put(tmp, v+1);
                }else{
                    hashMap2.put(tmp, 1);
                }
            }
        }
        
        double A = 0; //교
        double B = 0; //합
        
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            B += entry.getValue();
        }
        for (Map.Entry<String, Integer> entry : hashMap1.entrySet()) {
            if(hashMap2.containsKey(entry.getKey())){
                int a = entry.getValue();
                int b = hashMap2.get(entry.getKey());
                A += Math.min(a, b);
            }
        }
        
        B = B-A;
        
        if(B == 0) return 65536;
        if(A == 0 || hashMap1.size() == 0 || hashMap2.size() == 0) return 0;
        
        double answerTmp = A/B * 65536;
        answer = (int) answerTmp;
        
        return answer;
    }
}
