class Solution {
    public boolean solution(int x) {
        String temp = "";
        temp += x;
        int sum = 0;
        for (int i=0; i<temp.length(); i++) sum += temp.charAt(i) -'0';
        if (x%sum == 0) return true;
        return false;
    }
}