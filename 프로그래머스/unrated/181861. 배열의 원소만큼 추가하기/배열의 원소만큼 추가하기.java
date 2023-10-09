class Solution {
    public int[] solution(int[] arr) {
        int len = 0;
        for (int i: arr) len += i;
        int[] answer = new int[len];
        int idx = 0;
        
        for (int i: arr) {
            for (int j=0; j<i; j++) {
                answer[idx++] = i;
            }
        }
        return answer;
    }
}