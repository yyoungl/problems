import java.util.*;

class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();

        
        for (int i=0; i<code.length(); i++) {
            if (i % q == r) answer += code.charAt(i);
        }
        return answer;
    }
}