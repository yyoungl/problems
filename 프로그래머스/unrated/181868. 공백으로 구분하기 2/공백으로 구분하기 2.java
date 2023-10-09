class Solution {
    public String[] solution(String my_string) {
        String[] temp = my_string.split(" ");
        int cnt = 0;
        for (int i=0; i<temp.length; i++) {
            if (temp[i].equals("")) continue;
            cnt++;
        }
        String[] answer = new String[cnt];
        int idx = 0;
        for (int i=0; i<temp.length; i++) {
            if (temp[i].equals("")) continue;
            answer[idx++] = temp[i];
        }
        
        return answer;
    }
}