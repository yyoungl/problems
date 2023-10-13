class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i=0; i<temp.length; i++) {
            int num = Integer.valueOf(temp[i]);
            System.out.println(num);
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        answer += min +" ";
        answer += max;
        return answer;
    }
}