import java.util.*;

class Solution {
    
    
    public int solution(int[][] targets) {
        int answer = 0;
        int last = -1;
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        
        for (int[] t: targets) {
            if (last == -1) {
                answer++;
                last =  t[1];
            }
            if (t[0] < last && t[1] >= last) continue;
            answer++;
            last = t[1];
        } 
        
        return answer;
    }
}