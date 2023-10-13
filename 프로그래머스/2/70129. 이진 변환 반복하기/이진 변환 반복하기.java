class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        while (!s.equals("1")) {
            String temp = "";
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') temp += s.charAt(i);
                else answer[1] = answer[1]+1;
            }
            s = Integer.toBinaryString(temp.length());
            answer[0] = answer[0] + 1;
        }
        
        
        
        
        return answer;
    }
}

