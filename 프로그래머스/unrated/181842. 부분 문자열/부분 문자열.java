class Solution {
    public int solution(String str1, String str2) {
        if (str1.length() > str2.length()) return 0;
        for (int i=0; i<str2.length()-str1.length()+1; i++) {
            String temp = str2.substring(i, i+str1.length());
            if (temp.equals(str1)) return 1;
        }        
        return 0;
    }
}