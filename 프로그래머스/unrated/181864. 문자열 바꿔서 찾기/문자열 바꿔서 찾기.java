class Solution {
    public int solution(String myString, String pat) {
        int len = pat.length();
        if (myString.length() < pat.length()) return 0;
        
        String rStr = "";
        for (int i=0; i<myString.length(); i++) {
            if (myString.charAt(i) == 'A') rStr += 'B';
            else rStr += 'A';
        }
        
        for (int i=0; i<myString.length()-len+1; i++) {
            String temp = rStr.substring(i, i+len);
            if (temp.equals(pat)) return 1;
        }
        
        
        return 0;
    }
}