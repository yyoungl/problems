class Solution {
    public int solution(int n) {
        int answer = 0;
        String three = three(n);

        for (int i=0; i<three.length(); i++) {
            answer += (three.charAt(three.length() -i -1) -'0') * Math.pow(3, i);
        }
        
        return answer;
    }
    
    public String three(int n) {
        String result = "";
        while ( n> 0) {
            result += n % 3;
            n = n / 3;
        }
        return result;
    }
}