class Solution {
    public int solution(String[] strArr) {
        int max = 0;
        for (int i=0; i<strArr.length; i++)
            max = Math.max(strArr[i].length(), max);
        int[] cnt = new int[max+1];
        
        for (int i=0; i<strArr.length; i++) {
            cnt[strArr[i].length()]++;
        }
        int answer = 0;
        for (int i=0; i<cnt.length; i++) {
            answer = Math.max(answer, cnt[i]);
        }
        
        return answer;
    }
}