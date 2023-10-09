import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {

        ArrayList<String> temp = new ArrayList<>();
        for (String s: strArr) {
            if (!contains(s)) temp.add(s);
        }
        String[] answer = new String[temp.size()];
        
        for (int i=0; i<temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
    
    
    public boolean contains(String chk) {
        for (int i=0; i<chk.length() - 1; i++) {
            String temp = chk.substring(i, i+2);
            if (temp.equals("ad")) return true;
        }
        return false;
    }
}