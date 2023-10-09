class Solution {
    public int solution(int a, int b) {
        String temp1 = "";
        String temp2 = "";
        temp1 += a;
        temp1 += b;
        temp2 += b;
        temp2 += a;
        return Math.max(Integer.valueOf(temp1), Integer.valueOf(temp2));
    }
}