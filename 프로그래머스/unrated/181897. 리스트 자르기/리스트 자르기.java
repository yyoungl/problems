import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int start = 0;
        int end = 0;
        int hop = 1;
        switch (n) {
            case 1:
                end = slicer[1];
                break;
            case 2:
                start = slicer[0];
                end = num_list.length-1;
                break;
            case 3:
                start = slicer[0];
                end = slicer[1];
                break;
            case 4:
                start = slicer[0];
                end = slicer[1];
                hop = slicer[2];
                break;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (int i=start; i<=end; i+=hop) temp.add(num_list[i]);
        
        answer = new int[temp.size()];
        
        for (int i=0; i<temp.size(); i++) answer[i] = temp.get(i);
        
        
        return answer;
    }
}