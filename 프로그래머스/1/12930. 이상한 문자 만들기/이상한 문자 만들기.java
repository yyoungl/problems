import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length; i++) {
            String str = arr[i];
            if (str.equals(" ")) {
                answer += str;
                continue;
            }
            for (int j=0; j<arr[i].length(); j++) {
                String temp = "";
                temp += str.charAt(j);
                if (j%2==0) answer += temp.toUpperCase();
                else answer += temp.toLowerCase();
            }
            if (i < arr.length-1) 
                answer += " ";
        }
        int idx = s.length()-1;
        while (s.charAt(idx) == ' ') {
            answer += s.charAt(idx);
            idx--;
        }
        
        return answer;
    }
}