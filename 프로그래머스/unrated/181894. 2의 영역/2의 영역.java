import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> idx = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==2) idx.add(i);
        }
        
        if (idx.size() == 0) return new int[] {-1};
        
        int start = idx.get(0);
        int end = idx.get(idx.size()-1);
        
        if (start == end) {
            answer = new int[1];
            answer[0] = arr[start];
        }
        else {
            answer = new int[end-start+1];
            for (int i=start; i<=end; i++) {
                answer[i-start] = arr[i];
            }
        }
        return answer;
    }
}