class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int N = pat.length();
        for (int i=0; i<myString.length()-N+1; i++) {
            String temp = myString.substring(i, i+N);
            if (temp.equals(pat)) answer++;
        }
        return answer;
    }
}