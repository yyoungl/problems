class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        for (int r=0; r<parts.length; r++) {
            int start = parts[r][0];
            int end = parts[r][1];
            answer += my_strings[r].substring(start, end+1);
            
            
        }
        return answer;
    }
}