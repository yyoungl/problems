class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fibo = new int[100001];
        fibo[1] = 1;
        
        if (n < 2) return fibo[n];
        
        for (int i=2; i<=n; i++) {
            fibo[i] = (fibo[i-1]+fibo[i-2])%1234567;
        }
        
        
        return fibo[n];
    }
}