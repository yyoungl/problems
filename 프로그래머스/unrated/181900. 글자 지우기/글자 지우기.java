class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        boolean[] chk = new boolean[my_string.length()];
        for (int i: indices) {
            chk[i] = true;
        }
        for(int i=0; i<my_string.length(); i++) {
            if (!chk[i]) answer += my_string.charAt(i);
        }
        return answer;
    }
} 