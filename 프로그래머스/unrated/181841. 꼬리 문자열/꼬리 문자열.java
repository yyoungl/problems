class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for (String s: str_list) {
            if (contains(s, ex)) continue;
            answer += s;
        }
        return answer;
    }
    
    static boolean contains(String s, String ex) {
        if(s.length() < ex.length()) return false;
        
        int len = ex.length();
        
        for (int i=0; i<s.length()-len+1; i++) {
            String temp = s.substring(i, i+len);
            if (temp.equals(ex)) return true;
        }
        
        
        return false;
    }
}