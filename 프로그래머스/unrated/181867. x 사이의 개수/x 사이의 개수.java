import java.util.*;

class Solution {
    public int[] solution(String myString) {

        String[] temp = myString.split("x");
        int len = temp.length;
        if (myString.charAt(myString.length()-1) == 'x') len++;
        int[] answer = new int[len];
        

        for (int i=0; i<temp.length; i++) {
            answer[i] = temp[i].length();
        }
        
        return answer;
    }
}