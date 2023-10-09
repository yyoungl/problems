class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        
        
        int n = todo_list.length;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if (!finished[i]) cnt++;
        }
        
        String[] answer = new String[cnt];
        int idx = 0;
        for (int i=0; i<n; i++) {
            if (!finished[i]) answer[idx++] = todo_list[i];
        }
        
        
        return answer;
    }
}