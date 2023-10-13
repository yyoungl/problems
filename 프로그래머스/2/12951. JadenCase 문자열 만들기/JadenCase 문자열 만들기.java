class Solution {
    public String solution(String s) {
        String answer = "";
        answer += Character.toUpperCase(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' ') answer += " ";
            else if (s.charAt(i-1) == ' ') answer += Character.toUpperCase(temp);
            else answer += Character.toLowerCase(temp);
        }
        return answer;
    }
}