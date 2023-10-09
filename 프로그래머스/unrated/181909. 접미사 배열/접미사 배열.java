import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> temp = new ArrayList<>();
        int len = my_string.length();
        for (int i=0; i<len; i++) {
            temp.add(my_string.substring(i, len));
        }
        
        String[] answer = new String[temp.size()];
        for (int i=0; i<temp.size(); i++) answer[i] = temp.get(i);
        Arrays.sort(answer);
        return answer;
    }
}