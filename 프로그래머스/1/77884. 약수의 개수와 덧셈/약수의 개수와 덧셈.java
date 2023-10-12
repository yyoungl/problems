class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<=right; i++) {
            int temp = divide(i);
            System.out.println(temp);
            if (temp%2==1) answer-=i;
            else answer+=i;
        }
        return answer;
    }
    
    public static int divide(int num) {
        int cnt = 1;
        for (int i=1; i<=num/2; i++) {
            if (num%i==0) cnt++;
        }
        return cnt;
    }
}