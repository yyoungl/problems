class Solution {
    public int solution(String number) {
        int sum = 0;
        while (number.length() >= 10) {
            sum = 0;
            for (int i=0; i<number.length(); i++) sum += number.charAt(i) - '0';
            number = "";
            number += sum;
        }
        int answer = Integer.valueOf(number) % 9;
        return answer;
    }
}