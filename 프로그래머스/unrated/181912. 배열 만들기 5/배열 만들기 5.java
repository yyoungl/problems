class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int N = 0;
        
        for (int i=0; i<intStrs.length; i++) {
            int temp = Integer.valueOf(intStrs[i].substring(s, s+l));
            if(temp>k) N++; 
        }
        
        int[] answer = new int[N];
        int idx=0;
        for (int i=0; i<intStrs.length; i++) {
            int temp = Integer.valueOf(intStrs[i].substring(s, s+l));
            if(temp>k) answer[idx++] = temp;
        }
        
        return answer;
    }
}