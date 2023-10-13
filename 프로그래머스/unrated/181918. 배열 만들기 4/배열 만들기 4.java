import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
       
        ArrayList<Integer> result = new ArrayList<>();
        
        int i=0;
        result.add(arr[i]);
        i++;

        while(arr.length > i) {

           if (!result.isEmpty() && result.get(result.size()-1) < arr[i]) {
                result.add(arr[i]);
                i++;
            } else if (!result.isEmpty() && result.get(result.size()-1) >= arr[i]) {
                result.remove(result.size()-1);
            } else if (result.isEmpty()) {
               result.add(arr[i]);
               i++;
           }
        }
        
        int[] stk = new int[result.size()];
        for (int idx = 0; idx<result.size(); idx++) {
            stk[idx] = result.get(idx);
        }
        
        
        return stk;
    }
}