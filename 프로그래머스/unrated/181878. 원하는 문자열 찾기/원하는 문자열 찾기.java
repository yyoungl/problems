class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();
        if (myString.length() < pat.length()) return 0;
        
        for (int i=0; i<myString.length()-pat.length()+1; i++) {
            String temp = myString.substring(i, i+pat.length());
            if (pat.equals(temp)) return 1;
        }
        
        return 0;
    }
}