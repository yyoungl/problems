class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        if (power(len)) return arr;
        
        int answerLen = 1;
        while ( answerLen < len) {
            answerLen *=2;
        }
        int[] answer = new int[answerLen];
        for (int i=0; i<len; i++) {
            answer[i] = arr[i];
        }
        
        return answer;
    }
    
    public boolean power(int num) {
        while (num > 1) {
            if (num%2==1) return false;
            num = num/2;
        }
        
        return true;
    }
}