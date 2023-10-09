import java.util.*;

class Solution {
    public String solution(String rny_string) {
        String answer = "";
        ArrayList<Character> chars = new ArrayList<>();
        
        for (int i=0; i<rny_string.length(); i++) {
            if (rny_string.charAt(i)=='m') {
                chars.add('r');
                chars.add('n');
            } else chars.add(rny_string.charAt(i));
        }
        
        for (char c: chars) answer += c;
        
        return answer;
    }
}