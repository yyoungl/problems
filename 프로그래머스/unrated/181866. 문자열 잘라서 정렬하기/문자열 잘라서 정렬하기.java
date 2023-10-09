import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.trim().split("x");
        int len = arr.length;
        for (int i=0; i<arr.length; i++) {
            if (arr[i].equals("")) len--;
        }
        
        String[] answer = new String[len];
        int idx = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i].equals("")) {
                len--;
                continue;
            }
            answer[idx++] = arr[i];
        }
        
        
        Arrays.sort(answer);
        return answer;
    }
}