class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        System.out.println((int) 'A');
        System.out.println((int) 'a');
        for (int i=0; i<my_string.length(); i++) {
            int idx = 0;
            if (my_string.charAt(i) > 91) {
                idx = my_string.charAt(i)-'a'+26;
            }
            else {
                idx = my_string.charAt(i)-'A';
            }
            

            answer[idx] = answer[idx]+1;
        }
        
        return answer;
    }
}