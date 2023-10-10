import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int N = my_string.length() / m;
        char[][] chars = new char[N][m];
        for (int i=0; i<N; i++) {
            for (int j=0; j<m; j++) {
                chars[i][j] = my_string.charAt(m*i+j);
            }
        } 
        
        for (int i=0; i<N; i++) answer+=chars[i][c-1];
        
        for (char[] d: chars) System.out.println(Arrays.toString(d));
        
        return answer;
    }
}