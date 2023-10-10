class Solution {
    public String[] solution(String myStr) {
        String[] answer;
        myStr = myStr.replaceAll("a", " ").replaceAll("b", " ").replaceAll("c", " ");
        answer = myStr.split(" ");
        
        if (answer.length==0) {
            String[] one = new String[1];
            one[0] = "EMPTY";
            return one;
        }
        int cnt = 0;
        for (int i=0; i<answer.length; i++) {
            if (!answer[i].equals("")) cnt++;
        }
        String[] temp = new String[cnt];
        int idx = 0;
        for (int i=0; i<answer.length; i++) {
            if (!answer[i].equals("")) temp[idx++] = answer[i];
        }
        
        return temp;
    }
}