import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i: num_list) arr.add(i);
        if (arr.contains(n)) return 1;
        return 0;
    }
}