import java.util.*;

class Solution {
    public int[] solution(int n) {

        ArrayList<Integer> result = new ArrayList<>();
        while(n!=1) {
            result.add(n);
            if (n%2==1) n = 3*n+1;
            else n = n/2;
        }
        result.add(1);
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}