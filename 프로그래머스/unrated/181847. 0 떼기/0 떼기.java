class Solution {
    public String solution(String n_str) {
        String answer = n_str;
        int len;
        System.out.println(answer.charAt(0));
        while (answer.charAt(0) == '0') {
            len = answer.length();
            answer = answer.substring(1, len);
            
        }
        return answer;
    }
}