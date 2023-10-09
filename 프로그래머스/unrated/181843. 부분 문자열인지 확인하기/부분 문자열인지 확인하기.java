class Solution {
    public int solution(String my_string, String target) {
        for (int i=0; i<my_string.length()-target.length()+1; i++) {
            String temp = my_string.substring(i, i+target.length());
            if (temp.equals(target)) return 1;
        }
        return 0;
    }
}