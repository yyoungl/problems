import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> X = new ArrayList<>();
        for (int i=0; i<flag.length; i++) {
            if (flag[i]) {
                for (int cnt=0; cnt<2*arr[i]; cnt++) X.add(arr[i]);
            } else {
                for (int cnt=0; cnt<arr[i]; cnt++) {
                    if (!X.isEmpty()) X.remove(X.size()-1);
                }
            }
        }
        System.out.println(X.isEmpty());
        for (int i=0; i<X.size(); i++) System.out.print(X.get(i)+" ");
        
        int[] answer = new int[X.size()];
        
        for (int i=0; i<answer.length; i++) answer[i] = X.get(i);
        return answer;
    }
}