class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = getGCD(n, m);
        answer[1] = n * m / getGCD(n, m);
        return answer;
    }
    
    public int getGCD(int a, int b) {
        while (b>0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}